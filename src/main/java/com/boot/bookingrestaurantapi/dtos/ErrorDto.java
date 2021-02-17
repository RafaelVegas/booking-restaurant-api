package com.boot.bookingrestaurantapi.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class ErrorDto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String value;

	public ErrorDto(String name, String value) {
		this.name = name;
		this.value = value;
	}
}
