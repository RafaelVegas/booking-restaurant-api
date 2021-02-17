package com.boot.bookingrestaurantapi.service.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.repositories.ReservationRepository;
import com.boot.bookingrestaurantapi.service.CancelReservationServiceI;

public class CancelReservationService implements CancelReservationServiceI {

	private final static Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);

	@Autowired
	private ReservationRepository reservationRepository;

	public String deleteReservation(String locator) throws BookingException {
		reservationRepository.findByLocator(locator).orElseThrow(() -> new NotFoundException("Locator Error 404",
				"Reserva no encontrada con el localizador: " + locator));
		try {
			reservationRepository.deleteByLocator(locator);
		} catch (Exception e) {
			LOGGER.error("INTERNAL SERVER ERROR",e);
			new  InternalServerErrorException("INTERNAL SERVER ERROR ", "Error borrando la reserva con localizador: " + locator);
		}
		return "RESERVA BORRADA CORRECTAMENTE";
	}

}
