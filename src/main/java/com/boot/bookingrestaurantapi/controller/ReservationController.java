package com.boot.bookingrestaurantapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.jsons.CreateReservationRest;
import com.boot.bookingrestaurantapi.jsons.ReservationRest;
import com.boot.bookingrestaurantapi.responses.BookingRestaurantResponse;
import com.boot.bookingrestaurantapi.service.implement.ReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking" + "/v1.0")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST, value = "create-reservation", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingRestaurantResponse<String> createReservation(
			@RequestBody CreateReservationRest createReservationRest) throws BookingException {
		return new BookingRestaurantResponse<String>("SUCESS", String.valueOf(HttpStatus.OK), "Reserva creada",
				reservationService.createReservation(createReservationRest));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, value = "consult-reservation" + "/{" + "id" + "}", produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingRestaurantResponse<ReservationRest> findReservation(@PathVariable Long id) throws BookingException {
		return new BookingRestaurantResponse<>("SUCESS", String.valueOf(HttpStatus.OK), "Consulta realizada",
				reservationService.getReservation(id));
	}
}
