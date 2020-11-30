package com.cg.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.dto.CancelTicketBookingErrorMessage;
import com.cg.exceptions.InvalidBookingException;

@RestControllerAdvice
public class RestAdvice {
	@ExceptionHandler(InvalidBookingException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public CancelTicketBookingErrorMessage InvalidBookingException(InvalidBookingException ex) {
		return new CancelTicketBookingErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), LocalDateTime.now().toString());
}
	
}

