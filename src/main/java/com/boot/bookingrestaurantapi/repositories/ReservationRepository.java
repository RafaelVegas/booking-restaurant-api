package com.boot.bookingrestaurantapi.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.bookingrestaurantapi.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Optional<Reservation> findById(Long id);

	Optional<Reservation> findByLocator(String locator);

	@Modifying
	@Transactional
	Optional<Reservation> deleteByLocator(String Locator);

	Optional<Reservation> findByTurnAndRestaurant(String turn, Long idRestaurant);
}
