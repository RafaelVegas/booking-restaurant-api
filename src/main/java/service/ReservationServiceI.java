package service;

import exceptions.BookingException;
import jsons.CreateReservationRest;
import jsons.ReservationRest;

public interface ReservationServiceI {

	ReservationRest getReservation(Long id) throws BookingException;
	
	String createReservation(CreateReservationRest createReservationRest) throws BookingException;
	
}
