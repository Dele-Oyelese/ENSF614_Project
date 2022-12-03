package com.movie.moviebackend.controller;

import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.service.MovieService;
import com.movie.moviebackend.service.SeatService;
import com.movie.moviebackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {

    /* Ticket service for accessing the table of tickets */
    private final TicketService ticketService;

    /* ? Seat service for accessing the seats */
    private final SeatService seatService;

    /* ? Movie service for accessing the movies */
    private final MovieService movieService;

    @Autowired
    public MovieController(
            TicketService ticketService,
            SeatService seatService,
            MovieService movieService
    )
    {
        this.ticketService = ticketService;
        this.seatService = seatService;
        this.movieService = movieService;
    }

    /* Get all available movies at the theater */
    @GetMapping
    public List<Movie> getMovies()
    {
        return movieService.getAllMovies();
    }

    @GetMapping("/getByTitle/{movieTitle}")
    public List<Movie> getMovies(@PathVariable String movieTitle)
    {
        return movieService.getMoviesByTitle(movieTitle);
    }

    /* Add a new movie to the table by passing JSON format movie */
    @PostMapping("/add")
    public String addNewMovie(@RequestBody Movie movie)
    {
        movieService.addNewMovie(movie);
        seatService.addSeatsForNewMovie(movie);
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
