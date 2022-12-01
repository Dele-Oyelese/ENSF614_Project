package com.movie.moviebackend.repository;

import com.movie.moviebackend.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepo extends JpaRepository<Seat, Long> {

    @Query("SELECT seat FROM Seat seat WHERE seat.movieId = ?1")
    List<Seat> findSeatByMovieId(Long movieId);
}
