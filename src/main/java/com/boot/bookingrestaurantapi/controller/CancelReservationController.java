package com.boot.bookingrestaurantapi.controller;

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
import com.boot.bookingrestaurantapi.responses.BookingRestaurantResponse;
import com.boot.bookingrestaurantapi.service.implement.CancelReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/cancel-reservation")
public class CancelReservationController {

	@Autowired
	CancelReservationService cancelReservationService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE, value = "delete-by-id" + "/{" + "id" + "}")
	public BookingRestaurantResponse<String> cancelReservationByID(@PathVariable Long id)
			throws BookingException {
		return new BookingRestaurantResponse<>("SUCESS", String.valueOf(HttpStatus.OK), "OK",
				cancelReservationService.deleteReservation(id));
	}
}
