package com.movie.moviebackend.controller;

import com.movie.moviebackend.model.Seat;
import com.movie.moviebackend.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seat")
public class SeatController {
    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService)
    {
        this.seatService = seatService;
    }

    /* Get all seats in the table */
    @GetMapping("/getAll")
    public List<Seat> getSeats()
    {
        return seatService.getAllSeats();
    }

    /* Get all seats with the given movie ID */
    @GetMapping("/movie/{movieId}")
    public List<Seat> getMovieSeats(@PathVariable("movieId") Long movieId)
    {
        return seatService.getMovieSeats(movieId);
    }

    /* Add a new seat with JSON format seat */
    @PostMapping("/add")
    public String addNewSeat(@RequestBody Seat seat)
    {
        seatService.addNewSeat(seat);
        return "New seat added.";
    }

    /* Delete a seat of the given ID */
    @DeleteMapping(path = "{id}")
    public void deleteSeat(@PathVariable("id") Long id)
    {
        /* TODO: cancel all tickets with this seat id */
        seatService.deleteSeat(id);
    }

    /* Delete all seats in the given movie ID */
    @DeleteMapping("/movie/{movieId}")
    public void deleteMovieSeats(@PathVariable("movieId") Long movieId)
    {
        seatService.deleteMovieSeats(movieId);
    }

    /* Update the seat */
    @PutMapping(path = "{id}")
    public void updateSeat(
            @PathVariable("id") Long id,
            @RequestParam(required = false) Long movieId,
            @RequestParam(required = false) String seatNum,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) boolean available
    )
    {
       seatService.updateSeat(id, movieId, seatNum, price, available);
    }
}
