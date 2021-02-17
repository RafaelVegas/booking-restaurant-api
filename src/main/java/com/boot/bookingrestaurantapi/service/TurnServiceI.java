package com.boot.bookingrestaurantapi.service;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.TurnRest;

public interface TurnServiceI {

	TurnRest getTurnById(Long id) throws BookingException;	
}
