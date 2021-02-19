package com.boot.bookingrestaurantapi.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CancelReservation {

	@JsonProperty("idReservation")
	private Long idReservation;
	
	@JsonProperty("idReservation")
	private Long locator;
}
