package jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public RestaurantRest getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantRest restaurant) {
		this.restaurant = restaurant;
	}
}
