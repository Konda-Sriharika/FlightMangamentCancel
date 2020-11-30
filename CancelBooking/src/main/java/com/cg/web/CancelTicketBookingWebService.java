package com.cg.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exceptions.InvalidBookingException;
import com.cg.service.CancelTicketBookingService;
//import com.cg.util.ErrorConstants;

@RestController
public class CancelTicketBookingWebService {
@Autowired
CancelTicketBookingService bookingService;

@DeleteMapping("cancelBooking/{bid}")
public boolean deleteBooking(@PathVariable("bid") String bookingId) throws InvalidBookingException {
	bookingService.deleteBooking(bookingId);
	 return true;
}
}
//ErrorConstants.SEARCH_URL