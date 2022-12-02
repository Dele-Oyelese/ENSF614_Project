package com.movie.moviebackend.controller;


import com.movie.moviebackend.model.BoxOffice;
import com.movie.moviebackend.service.BoxOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

//Add contoller and API end point for BoxOffice Objects. Enable CrossOrigin
@RestController
@RequestMapping(path ="api/v1/boxOffice")
@CrossOrigin
public class BoxOfficeController {

    //declare a boxOffice service object as final
    private final BoxOfficeService boxOfficeService;

    //Set the BoxOffice contoller to have service objecy
    @Autowired
    public BoxOfficeController(BoxOfficeService boxOfficeService){
        this.boxOfficeService =boxOfficeService;

    }
//Set mapping to get all boxOffice Objects
    @GetMapping
    public List<BoxOffice> getAllBoxOffice(){return boxOfficeService.getAllBoxOffice();}

//Set mapping to get the ticket information and its boxOffice info
    @GetMapping("/get/{ticketId}")
    public BoxOffice getTicket(
            @PathVariable Long ticketId
    ){
        return boxOfficeService.getOneTicket(ticketId);
    }

    //Put mapping for purchasing a ticket with movie Id and Seat Id and RegisteredUser flag
    @PutMapping("/purchase/{ticketId}/movie/{movieId}/seat/{seatId}/ru/{flag}")
    public void purchaseTicket(
            @PathVariable Long movieId,
            @PathVariable Long ticketId,
            @PathVariable int seatId,
            @PathVariable int flag
    ){
        boxOfficeService.purchaseTicketForMovie(ticketId,movieId,seatId,flag);
    }



// Put mapping to cancel a ticket based on its id
    @PutMapping("/cancel/{ticketId}")
    public void cancelTicket(
            @PathVariable Long ticketId
    ){
        boxOfficeService.cancelTicketForMovie(ticketId);
    }

}
