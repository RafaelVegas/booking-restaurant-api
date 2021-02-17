package service.implement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import exceptions.BookingException;
import exceptions.InternalServerErrorException;
import exceptions.NotFoundException;
import repositories.ReservationRepository;
import service.CancelReservationServiceI;

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
