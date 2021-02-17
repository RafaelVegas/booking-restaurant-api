package service.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Turn;
import exceptions.BookingException;
import exceptions.NotFoundException;
import jsons.TurnRest;
import repositories.TurnRepository;
import service.TurnServiceI;

public class TurnService implements TurnServiceI{

	@Autowired
	TurnRepository turnRepository;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public TurnRest getTurnById(Long id) throws BookingException {		
		return modelMapper.map(getTurnEntity(id), TurnRest.class);
	}

	private Turn getTurnEntity(Long id) throws BookingException{
		return turnRepository.findById(id).orElseThrow(
				() -> new NotFoundException("Error 404 ", "Turno no registrado con id = " + id));
	}
}
