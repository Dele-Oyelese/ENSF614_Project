package com.movie.moviebackend.extraCode;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/seat")
public class SeatController {
//    private final SeatService seatService;
//
//    @Autowired
//    public SeatController(SeatService seatService)
//    {
//        this.seatService = seatService;
//    }
//
//    /* Get all seats in the table */
//    @GetMapping("/getAll")
//    public List<Seat> getSeats()
//    {
//        return seatService.getAllSeats();
//    }
//
//
//
//    /* Add a new seat with JSON format seat */
//    @PostMapping("/add")
//    public String addNewSeat(@RequestBody Seat seat)
//    {
//        seatService.addNewSeat(seat);
//        return "New seat added.";
//    }
//
//    /* Delete a seat of the given ID */
//    @DeleteMapping(path = "{id}")
//    public void deleteSeat(@PathVariable("id") Long id)
//    {
//        /* TODO: cancel all tickets with this seat id */
//        seatService.deleteSeat(id);
//    }




}
