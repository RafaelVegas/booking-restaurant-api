package exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import dtos.ErrorDto;

public class InternalServerErrorException extends BookingException{

	private static final long serialVersionUID = 1L;

	public InternalServerErrorException(String code, List<ErrorDto> errorList, String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), errorList, message);
	}
	
	public InternalServerErrorException(String code,  String message) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
	}
}
