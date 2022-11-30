package com.movie.moviebackend.service;

import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo)
    {
        this.movieRepo = movieRepo;
    }

    /* Get all movies in the database */
    public List<Movie> getAllMovies()
    {
        return movieRepo.findAll();
    }

    /* Add a new movie to the database */
    public void addNewMovie(Movie movie)
    {
        Optional<Movie> movieById = movieRepo.findById(movie.getId());

        if(movieById.isPresent())
        {
            throw new IllegalStateException("Movie already exists.");
        }

        movieRepo.save(movie);
    }

    /* Delete a movie from the database */
    public void deleteMovie(Long id)
    {
        boolean exists = movieRepo.existsById(id);
        if(!exists)
        {
            throw new IllegalStateException("Movie with id " + id + " does not exist.");
        }
        else
        {
            movieRepo.deleteById(id);
        }
    }

    /* Update a movie in the database */
    @Transactional
    public void updateMovie(Long id, String title, String showTime)
    {
        Movie movie = movieRepo.findById(id).orElseThrow(
                () -> new IllegalStateException("Movie with id " + id + " does not exist.")
        );

        /* Check to see if the title is acceptable */
        /* All movies with this title will be changed. */
        if(title != null && title.length() > 0 && !Objects.equals(movie.getTitle(), title) )
        {
            movie.setTitle(title);
        }

        /* Check to see if the show time is acceptable */
        /* Only the movie with matching title and showtime will be changed. */
        if(showTime != null && !Objects.equals(movie.getShowTime(), showTime) )
        {
            /* TODO: Need to figure out this implementation */

            movie.setShowTime(showTime);
        }
    }
}
