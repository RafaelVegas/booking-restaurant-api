package com.boot.bookingrestaurantapi.service;

import com.boot.bookingrestaurantapi.exceptions.BookingException;

public interface EmailServiceI {
	
	public String processSendEmail(final String receiver, String templadeCode, String currentName) throws BookingException;

}
