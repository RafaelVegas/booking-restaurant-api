package com.boot.bookingrestaurantapi.service;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.BoardRest;

public interface BoardServiceI {

	BoardRest findBoardById(Long id) throws BookingException;
}
