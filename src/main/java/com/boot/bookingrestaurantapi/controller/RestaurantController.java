package com.boot.bookingrestaurantapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.AllRestaurantsRest;
import com.boot.bookingrestaurantapi.jsons.AllRestaurantsTurnsBoardsRest;
import com.boot.bookingrestaurantapi.responses.BookingRestaurantResponse;
import com.boot.bookingrestaurantapi.service.implement.RestaurantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
@RequestMapping(path = "/booking-restaurant" + "/v1.0")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurant" + "/{" + "restaurantId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingRestaurantResponse<AllRestaurantsTurnsBoardsRest> getBookingRestaurantById(@PathVariable Long restaurantId)
			throws BookingException {
		return new BookingRestaurantResponse<>("SUCCES", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "allsRestaurants-Turns-Boards",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingRestaurantResponse<List<AllRestaurantsTurnsBoardsRest>> getAllBookingRestaurant() throws BookingException{
		return new BookingRestaurantResponse<>("SUCCESS",String.valueOf(HttpStatus.OK),"Proceso ejecutado correctamente", restaurantService.getAllRestaurant());
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "allRestaurant",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingRestaurantResponse<List<AllRestaurantsRest>> getOnlyRestaurans() throws BookingException{
		return new BookingRestaurantResponse<>("SUCCESS",String.valueOf(HttpStatus.OK),"Proceso ejecutado correctamente", restaurantService.getOnlyRestaurants());
	}
}
