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

    @GetMapping("/getAll")
    public List<Seat> getSeats()
    {
        return seatService.getAllSeats();
    }

    @PostMapping("/add")
    public String addNewSeat(@RequestBody Seat seat)
    {
        seatService.addNewSeat(seat);
        return "New seat added.";
    }

    @DeleteMapping(path = "{id}")
    public void deleteSeat(@PathVariable("id") Long id)
    {
        seatService.deleteSeat(id);
    }

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
