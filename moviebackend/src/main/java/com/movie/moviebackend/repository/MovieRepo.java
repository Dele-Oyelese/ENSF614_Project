package com.movie.moviebackend.repository;

import com.movie.moviebackend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Initiate Movie Repository as a JPA
@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

    //Add the additional Query to find a movie by title
    @Query("SELECT s FROM Movie s WHERE s.title = ?1")
    Optional <Movie> findMovieByTitle(String title);

}
