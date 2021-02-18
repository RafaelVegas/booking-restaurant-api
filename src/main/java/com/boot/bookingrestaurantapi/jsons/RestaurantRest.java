package com.boot.bookingrestaurantapi.jsons;

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
	
	@JsonProperty("turns")
	private List<TurnRest> turns;

	@JsonProperty("boards")
	private List<BoardRest> boards;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<TurnRest> getTurns() {
		return turns;
	}

	public void setTurns(List<TurnRest> turns) {
		this.turns = turns;
	}

	public List<BoardRest> getBoards() {
		return boards;
	}

	public void setBoards(List<BoardRest> boards) {
		this.boards = boards;
	}
}
