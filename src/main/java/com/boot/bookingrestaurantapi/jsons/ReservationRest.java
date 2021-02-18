package com.boot.bookingrestaurantapi.jsons;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private AllRestaurantsTurnsBoardsRest restaurant;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public Long getPerson() {
		return person;
	}

	public void setPerson(Long person) {
		this.person = person;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public AllRestaurantsTurnsBoardsRest getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(AllRestaurantsTurnsBoardsRest restaurant) {
		this.restaurant = restaurant;
	}
}
