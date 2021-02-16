package service;

import exceptions.BookingException;
import jsons.RestaurantRest;

public interface RestaurantServiceI {
	
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException ;
}
