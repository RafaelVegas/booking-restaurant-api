package service;

import exceptions.BookingException;
import jsons.TurnRest;

public interface TurnServiceI {

	TurnRest getTurnById(Long id) throws BookingException;	
}
