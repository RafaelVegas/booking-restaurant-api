package jsons;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantRest {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("locator")
	private String locator;

	@JsonProperty("image")
	private String image;

	@JsonProperty("reservation")
	private List<ReservationRest> reservations;

	@JsonProperty("board")
	private List<BoardRest> boards;

	@JsonProperty("turn")
	private List<TurnRest> turns;
}
