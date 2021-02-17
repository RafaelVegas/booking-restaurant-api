package service;

import exceptions.BookingException;

public interface CancelReservationServiceI {

	String deleteReservation(String locator) throws BookingException;
}
