package com.boot.bookingrestaurantapi.service;

import java.util.List;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.AllRestaurantsRest;
import com.boot.bookingrestaurantapi.jsons.AllRestaurantsTurnsBoardsRest;

public interface RestaurantServiceI {
	
	AllRestaurantsTurnsBoardsRest getRestaurantById(Long restaurantId) throws BookingException ;
	
	AllRestaurantsTurnsBoardsRest getRestaurantByName(String nameRestaurant) throws BookingException ;
	
	List<AllRestaurantsRest> getOnlyRestaurants() throws BookingException;
	
	List<AllRestaurantsTurnsBoardsRest> getAllRestaurant() throws BookingException;
}
