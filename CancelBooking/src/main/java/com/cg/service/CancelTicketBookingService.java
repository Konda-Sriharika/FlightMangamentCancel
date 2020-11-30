package com.cg.service;

import com.cg.exceptions.InvalidBookingException;

public interface CancelTicketBookingService {
	public boolean deleteBooking(String bookingId)throws InvalidBookingException;

}
