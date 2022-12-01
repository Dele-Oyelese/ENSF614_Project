package com.movie.moviebackend.controller;

import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    /* Get all available movies at the theater */
    @GetMapping("/getAll")
    public List<Movie> getMovies()
    {
        return movieService.getAllMovies();
    }

    /* Add a new movie to the table by passing JSON format movie */
    @PostMapping("/add")
    public String addNewMovie(@RequestBody Movie movie)
    {
        movieService.addNewMovie(movie);
        return "New movie added.";
    }

    /* Delete the movie listing of the given ID */
    @DeleteMapping(path = "{id}")
    public void deleteMovie(@PathVariable("id") Long id)
    {
        /* TODO: delete all seats */
            /* TODO: delete all tickets (inside seat) */
        movieService.deleteMovie(id);
    }

    /* Update the movie by passing certain parameters */
    @PutMapping(path = "{id}")
    public void updateMovie(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String showTime
    )
    {
        movieService.updateMovie(id, title, showTime);
    }
}
