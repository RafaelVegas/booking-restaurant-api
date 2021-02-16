package exceptions;

import java.util.LinkedList;
import java.util.List;

import dtos.ErrorDto;
import lombok.Getter;
import lombok.Setter;


public class BookingException extends Exception{

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private final String code;
	
	@Getter
	@Setter
	private final int responseCode;
	
	@Getter
	@Setter
	private final List<ErrorDto> errorList = new LinkedList<>();

	public BookingException(String code, int responseCode, String  message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
	}

	public BookingException(String code, int responseCode,List<ErrorDto> errorList, String message) {
		super(message);
		this.code = code;
		this.responseCode = responseCode;
		this.errorList.addAll(errorList);
	}		

}
