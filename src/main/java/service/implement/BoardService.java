package service.implement;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Board;
import exceptions.BookingException;
import exceptions.NotFoundException;
import jsons.BoardRest;
import repositories.BoardRepository;
import service.BoardServiceI;

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
