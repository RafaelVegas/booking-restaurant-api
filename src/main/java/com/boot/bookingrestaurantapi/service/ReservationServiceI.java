package com.boot.bookingrestaurantapi.service;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.CreateReservationRest;
import com.boot.bookingrestaurantapi.jsons.ReservationRest;

public interface ReservationServiceI {

	ReservationRest getReservation(Long id) throws BookingException;
	
	String createReservation(CreateReservationRest createReservationRest) throws BookingException;
	
}
