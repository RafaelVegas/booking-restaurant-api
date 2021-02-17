package jsons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TurnRest {

	@JsonProperty("id")
	private Long id;
		
	@JsonProperty("name")
	private String name;	
	
	@JsonProperty("restaurant")
	private RestaurantRest restaurant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RestaurantRest getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantRest restaurant) {
		this.restaurant = restaurant;
	}
}
