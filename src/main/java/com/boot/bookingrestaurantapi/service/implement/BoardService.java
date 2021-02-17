package com.boot.bookingrestaurantapi.service.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.boot.bookingrestaurantapi.entities.Board;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.jsons.BoardRest;
import com.boot.bookingrestaurantapi.repositories.BoardRepository;
import com.boot.bookingrestaurantapi.service.BoardServiceI;

public class BoardService implements BoardServiceI{

	@Autowired
	BoardRepository boardRepository;
	
	private static ModelMapper modelMappper = new ModelMapper();

	public BoardRest findBoardById(Long id) throws BookingException{
		return modelMappper.map(findByBoardEntity(id), BoardRest.class);
	}
	
	private Board findByBoardEntity(Long id) throws BookingException{
		return boardRepository.findById(id).orElseThrow(()-> new NotFoundException("Error 404 ", "Mesa no encontrado por el id: " + id));
	}
}
