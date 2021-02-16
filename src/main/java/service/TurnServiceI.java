package service;

import org.springframework.beans.factory.annotation.Autowired;

import exceptions.BookingException;
import jsons.TurnRest;

public interface TurnServiceI {

	TurnRest getTurnById(Long id) throws BookingException;	
}
