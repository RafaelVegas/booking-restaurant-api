package com.boot.bookingrestaurantapi.service.implement;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.entities.Turn;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.jsons.CreateReservationRest;
import com.boot.bookingrestaurantapi.jsons.ReservationRest;
import com.boot.bookingrestaurantapi.repositories.ReservationRepository;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.repositories.TurnRepository;
import com.boot.bookingrestaurantapi.service.ReservationServiceI;

@Service
public class ReservationService implements ReservationServiceI {

	private final static Logger LOGGER = LoggerFactory.getLogger(ReservationService.class);

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private TurnRepository turnRepository;
	
	@Autowired
	private EmailService emailService;

	private ModelMapper modelMapper = new ModelMapper();

	public ReservationRest getReservation(Long id) throws BookingException {
		return modelMapper.map(findByReservationByIdEntity(id), ReservationRest.class);
	}

	public String createReservation(CreateReservationRest createReservationRest) throws BookingException {
		final Restaurant restauranteEntity = restaurantRepository.findById(createReservationRest.getRestaurantId())
				.orElseThrow(() -> new NotFoundException("Error 404 ",
						"Restaurante no registrado con el id de restaurante: " + createReservationRest.getRestaurantId() + ", o con el turno: " + createReservationRest.getTurnId()));

		final Turn turnEntity = turnRepository.findById(createReservationRest.getTurnId())
				.orElseThrow(() -> new NotFoundException("Error 404 ",
						"Turno no encontrado con id: " + createReservationRest.getTurnId()));

		String locator = getLocator(restauranteEntity, createReservationRest);

		final Reservation reservation = new Reservation();
		reservation.setLocator(locator);
		reservation.setPerson(createReservationRest.getPerson());
		reservation.setDate(createReservationRest.getDate());
		reservation.setRestaurant(restauranteEntity);
		reservation.setTurn(turnEntity.getName());
		reservation.setPayment(createReservationRest.isPayment());
		reservation.setEmail(createReservationRest.getEmail());
		reservation.setName(createReservationRest.getName());
		
		try {
			reservationRepository.save(reservation);
		} catch (Exception e) {
			LOGGER.error("INTERNAL SERVER ERROR ", e);
			throw new InternalServerErrorException("Internal SERVER ERROR ",
					"La reservada no ha sido guardada correctamente");
		}
		
		emailService.processSendEmail(createReservationRest.getEmail(), "RESERVATION", createReservationRest.getName());

		return "Reserva creada con localizador: " + locator;
	}

	private Reservation findByReservationByIdEntity(Long id) throws BookingException {
		return reservationRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Error 404 ", "Reserva no encontrada con id: " + id));
	}

	private String getLocator(final Restaurant restaurantEntity, final CreateReservationRest createReservationRest)
			throws BookingException {
		return restaurantEntity.getName() + " - " +createReservationRest.getTurnId() + "- direcciòn: " + restaurantEntity.getLocator();
	}

}
