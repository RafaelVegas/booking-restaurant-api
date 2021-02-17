package com.boot.bookingrestaurantapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;
import com.boot.bookingrestaurantapi.responses.BookingRestaurantResponse;
import com.boot.bookingrestaurantapi.service.implement.RestaurantService;

@RestController
@RequestMapping("/booking-restaurant" + "v1.0")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	public BookingRestaurantResponse<RestaurantRest> getBookingRestaurantById(Long restaurantId) throws BookingException{
		
		return new BookingRestaurantResponse<>("SUCESS", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurantById(restaurantId));
	}
}
