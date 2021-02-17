package com.boot.bookingrestaurantapi.service;

import com.boot.bookingrestaurantapi.exceptions.BookingException;

public interface CancelReservationServiceI {

	String deleteReservation(String locator) throws BookingException;
}
