package com.boot.bookingrestaurantapi.service.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.repositories.ReservationRepository;
import com.boot.bookingrestaurantapi.service.CancelReservationServiceI;

@Service
public class CancelReservationService implements CancelReservationServiceI {

	private final static Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);

	@Autowired
	private ReservationRepository reservationRepository;

	public String deleteReservation(Long id) throws BookingException {
		reservationRepository.findById(id).orElseThrow(() -> new NotFoundException("Locator Error 404",
				"Reserva no encontrada con el id: " + id));
		try {				
			reservationRepository.deleteReservationById(id);
		} catch (Exception e) {
			LOGGER.error("INTERNAL SERVER ERROR",e);
			new  InternalServerErrorException("INTERNAL SERVER ERROR ", "Error borrando la reserva con id: " + id);
		}
		return "RESERVA BORRADA" ;
	}

}
