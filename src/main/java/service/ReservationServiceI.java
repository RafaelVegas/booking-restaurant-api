package service;

import exceptions.BookingException;
import jsons.ReservationRest;

public interface ReservationServiceI {

	ReservationRest getReservation(Long id) throws BookingException;
	
}
