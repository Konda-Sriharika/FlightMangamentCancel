package com.cg.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.BookingDao;
import com.cg.dao.ScheduleFlightDao;
import com.cg.entity.Booking;
import com.cg.entity.ScheduledFlight;
import com.cg.exceptions.InvalidBookingException;
import com.cg.util.ErrorConstants;
@Service("myservice")
@Transactional
public class CancelTicketBookingImpl implements CancelTicketBookingService {
@Autowired
BookingDao bookingDao;
@Autowired
ScheduleFlightDao scheduleflightdao;
	@Override
	public boolean deleteBooking(String bookingId) throws InvalidBookingException {
		
		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		if (findBookingById.isPresent()) {
			Booking booking=findBookingById.get();
			if(booking.getSchedule().getArrivalTime().toLocalDate().isAfter(LocalDate.now()))
				throw new InvalidBookingException(ErrorConstants.NOT_CANCELLED); 
			booking.setBookingStatus(ErrorConstants.BOOKING_CANCEL);
			bookingDao.save(booking);
			ScheduledFlight schedule=booking.getSchedule();
			schedule.setAvailableSeats( schedule.getAvailableSeats() - booking.getNoOfSeats());
			return true;
		} else
			throw new InvalidBookingException(ErrorConstants.BOOKING_NOT_FOUND);
}
}
		
