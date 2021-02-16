package jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BoardRest {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("capacity")
	private Long capacity;

	@JsonProperty("number")
	private Long number;

	@JsonProperty("restaurant")
	private RestaurantRest restaurant;
}