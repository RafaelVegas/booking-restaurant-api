package controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.BookingException;
import service.implement.RestaurantService;

@RestController
@RequestMapping("/booking-restaurant" + "v1.0")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public RestaurantService getRestaurantService(Long id) throws BookingException {
		return modelMapper.map(restaurantService.getRestaurantById(id), RestaurantService.class);
	}

}
