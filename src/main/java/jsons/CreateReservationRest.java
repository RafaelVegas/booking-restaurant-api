package jsons;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateReservationRest {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("person")
	private Long person;
	
	@JsonProperty("turnId")
	private Long turnId;
	
	@JsonProperty("date")
	private Date date;
	
	@JsonProperty("restaurantId")
	private Long restaurantId;
}
