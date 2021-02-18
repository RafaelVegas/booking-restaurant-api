package com.boot.bookingrestaurantapi.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.exceptions.BookingException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.jsons.AllRestaurantsRest;
import com.boot.bookingrestaurantapi.jsons.AllRestaurantsTurnsBoardsRest;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.service.RestaurantServiceI;

@Service
public class RestaurantService implements RestaurantServiceI {

	@Autowired
	RestaurantRepository restaurantRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	public AllRestaurantsTurnsBoardsRest getRestaurantById(Long restaurantId) throws BookingException {
		return modelMapper.map(getRestaurantEntity(restaurantId), AllRestaurantsTurnsBoardsRest.class);
	}

	public AllRestaurantsTurnsBoardsRest getRestaurantByName(String nameRestaurant) throws BookingException {
		return modelMapper.map(getRestaurantEntityByName(nameRestaurant), AllRestaurantsTurnsBoardsRest.class);
	}

	public List<AllRestaurantsTurnsBoardsRest> getAllRestaurant() throws BookingException {
		final List<Restaurant> restaurantEntity = restaurantRepository.findAll();
		return restaurantEntity.stream()
				.map(service -> modelMapper
				.map(service, AllRestaurantsTurnsBoardsRest.class))
				.collect(Collectors.toList());
	}

	public List<AllRestaurantsRest> getOnlyRestaurants() throws BookingException {
		final List<Restaurant> restaurantsEntities = restaurantRepository.findAll();
		return restaurantsEntities.stream()
				.map(service -> modelMapper
				.map(service, AllRestaurantsRest.class))
				.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
		return restaurantRepository.findById(restaurantId).orElseThrow(
				() -> new NotFoundException("Error 404 ", "Restaurante no registrado con id = " + restaurantId));
	}

	private Restaurant getRestaurantEntityByName(String nameRestaurant) throws BookingException {
		return restaurantRepository.findByName(nameRestaurant).orElseThrow(() -> new NotFoundException("Error 404 ",
				"Nombre del restaurante no registrado con nombre " + nameRestaurant));
	}

}
