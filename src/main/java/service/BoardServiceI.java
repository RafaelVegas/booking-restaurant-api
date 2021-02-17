package service;

import exceptions.BookingException;
import jsons.BoardRest;

public interface BoardServiceI {

	BoardRest findBoardById(Long id) throws BookingException;
}
