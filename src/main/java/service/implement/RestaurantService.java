package service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import entities.Restaurant;
import exceptions.BookingException;
import exceptions.NotFoundException;
import jsons.RestaurantRest;
import repositories.RestaurantRepository;
import service.RestaurantServiceI;

public class RestaurantService implements RestaurantServiceI {

	@Autowired
	RestaurantRepository restaurantRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
		return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
	}

	public RestaurantRest getRestaurantByName(String nameRestaurant) throws BookingException {
		return modelMapper.map(getRestaurantEntityByName(nameRestaurant), RestaurantRest.class);
	}
	
	public List<RestaurantRest> getAllRestaurant() throws BookingException {
		final List<Restaurant> restaurantEntity = restaurantRepository.findAll();
		return restaurantEntity.stream().map(service -> modelMapper
				.map(service, RestaurantRest.class))
				.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(Long restaurantId) throws BookingException {
		return restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new NotFoundException("Error 404 ", "Restaurante no registrado con id = " + restaurantId));
	}

	private Restaurant getRestaurantEntityByName(String nameRestaurant) throws BookingException {
		return restaurantRepository.findByName(nameRestaurant)
				.orElseThrow(() -> new NotFoundException("Error 404 ","Nombre del restaurante no registrado con nombre " + nameRestaurant));
	}
}
