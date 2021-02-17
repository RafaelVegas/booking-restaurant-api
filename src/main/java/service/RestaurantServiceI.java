package service;

import exceptions.BookingException;
import jsons.RestaurantRest;

public interface RestaurantServiceI {
	
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException ;
	
	RestaurantRest getRestaurantByName(String nameRestaurant) throws BookingException ;
}
