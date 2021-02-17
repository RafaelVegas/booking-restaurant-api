package com.boot.bookingrestaurantapi.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.boot.bookingrestaurantapi.dtos.ErrorDto;

public class NotFoundException extends BookingException{

	private static final long serialVersionUID = 1L;

	public NotFoundException(String code, List<ErrorDto> errorList, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), errorList, message);
	}

	public NotFoundException(String code, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
		
	}
	
	

}
