package jsons;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRest {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("locator")
	private String locator;

	@JsonProperty("person")
	private Long person;

	@JsonProperty("date")
	private Date date;

	@JsonProperty("turn")
	private String turn;

	@JsonProperty("restaurant")
	private RestaurantRest restaurant;
}
