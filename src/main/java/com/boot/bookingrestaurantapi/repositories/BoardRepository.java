package com.boot.bookingrestaurantapi.repositories;

import java.util.Optional;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.bookingrestaurantapi.entities.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Id>{

	Optional<Board> findById(Long id);
}
