package com.movie.moviebackend.controller;

import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies()
    {
        return movieService.getAllMovies();
    }

//    @PostMapping("/add")
//    public String addNewMovie(@RequestBody Movie movie)
//    {
//        movieService.addNewMovie(movie);
//        return "New movie added.";
//    }

    @DeleteMapping(path = "{id}")
    public void deleteMovie(@PathVariable("id") Long id)
    {
        movieService.deleteMovie(id);
    }

//    @PutMapping(path = "{id}")
//    public void updateMovie(
//            @PathVariable("id") Long id,
//            @RequestParam(required = false) String title,
//            @RequestParam(required = false) String showTime)
//    {
//        movieService.updateMovie(id, title, showTime);
//    }

    @GetMapping("title/{title}")
    public Movie getMovie(@PathVariable(required = false) String title) {
        return movieService.getMovieByTitle(title);
    }
}
