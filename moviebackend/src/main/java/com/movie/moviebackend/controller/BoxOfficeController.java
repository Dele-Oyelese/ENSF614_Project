package com.movie.moviebackend.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.movie.moviebackend.model.BoxOffice;
import com.movie.moviebackend.service.BoxOfficeService;
import com.movie.moviebackend.service.MovieService;
import com.movie.moviebackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/boxOffice")
@CrossOrigin
public class BoxOfficeController {

    private final MovieService movieService;
    private final TicketService ticketService;
    private final BoxOfficeService boxOfficeService;

    @Autowired
    public BoxOfficeController(MovieService movieService,TicketService ticketService, BoxOfficeService boxOfficeService){
        this.boxOfficeService =boxOfficeService;
        this.movieService = movieService;
        this.ticketService =ticketService;
    }

    @GetMapping
    public List<BoxOffice> getAllBoxOffice(){return boxOfficeService.getAllBoxOffice();}


    @GetMapping("/get/{ticketId}/movie/{movieId}")
    public BoxOffice getTicket(
            @PathVariable Long movieId,
            @PathVariable Long ticketId
    ){
        return boxOfficeService.getOneTicket(ticketId,movieId);
    }

    @PutMapping("/purchase/{ticketId}/movie/{movieId}")
    public void purchaseTicket(
            @PathVariable Long movieId,
            @PathVariable Long ticketId
    ){
        boxOfficeService.purchaseTicketForMovie(ticketId,movieId);
    }

    @PutMapping("/cancel/{ticketId}/movie/{movieId}")
    public void cancelTicket(
            @PathVariable Long movieId,
            @PathVariable Long ticketId
    ){
        boxOfficeService.cancelTicketForMovie(ticketId,movieId);
    }

}
