package com.movie.moviebackend.repository;

import com.movie.moviebackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
    List<Movie> findMovieByMovieTitle(String movieTitle);
}
