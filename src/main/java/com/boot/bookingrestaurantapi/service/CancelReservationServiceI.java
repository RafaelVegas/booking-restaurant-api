package com.boot.bookingrestaurantapi.service;

import com.boot.bookingrestaurantapi.exceptions.BookingException;


public interface CancelReservationServiceI {

	String deleteReservation(Long idReservation) throws BookingException;
}
