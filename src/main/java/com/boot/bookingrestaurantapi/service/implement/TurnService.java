package com.boot.bookingrestaurantapi.service.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.bookingrestaurantapi.entities.Turn;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.jsons.TurnRest;
import com.boot.bookingrestaurantapi.repositories.TurnRepository;
import com.boot.bookingrestaurantapi.service.TurnServiceI;

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
