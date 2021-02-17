package service.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Reservation;
import exceptions.BookingException;
import exceptions.NotFoundException;
import jsons.ReservationRest;
import repositories.ReservationRepository;
import service.ReservationServiceI;

public class ReservationService implements ReservationServiceI{

	@Autowired
	ReservationRepository repository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public ReservationRest getReservation(Long id) throws BookingException {
		return modelMapper.map(findByReservationByIdEntity(id), ReservationRest.class);
	}

	private Reservation findByReservationByIdEntity(Long id) throws BookingException{
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Error 404 ", "Reserva no encontrada con id: " + id));
	}
}
