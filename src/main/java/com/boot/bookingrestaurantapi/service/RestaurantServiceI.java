package com.boot.bookingrestaurantapi.service;

import java.util.List;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.RestaurantRest;

public interface RestaurantServiceI {
	
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException ;
	
	RestaurantRest getRestaurantByName(String nameRestaurant) throws BookingException ;
	
	List<RestaurantRest> getAllRestaurant() throws BookingException;
}
