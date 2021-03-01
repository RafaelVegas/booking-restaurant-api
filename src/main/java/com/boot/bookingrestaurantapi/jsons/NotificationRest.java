package com.boot.bookingrestaurantapi.jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationRest {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("template")
	private String template;
	
	@JsonProperty("template_code")
	private String templateCode;
}
