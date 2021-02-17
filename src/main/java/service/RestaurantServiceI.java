package service;

import java.util.List;

import exceptions.BookingException;
import jsons.RestaurantRest;

public interface RestaurantServiceI {
	
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException ;
	
	RestaurantRest getRestaurantByName(String nameRestaurant) throws BookingException ;
	
	List<RestaurantRest> getAllRestaurant() throws BookingException;
}
