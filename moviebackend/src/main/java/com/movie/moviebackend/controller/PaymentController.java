package com.movie.moviebackend.controller;

import com.movie.moviebackend.model.Payment;
import com.movie.moviebackend.service.MovieService;
import com.movie.moviebackend.service.PaymentService;
import com.movie.moviebackend.service.SeatService;
import com.movie.moviebackend.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/payment")
public class PaymentController {

    /* Ticket service for accessing the table of tickets */
    private final TicketService ticketService;

    /* ? Seat service for accessing the seats */
    private final SeatService seatService;

    /* ? Movie service for accessing the movies */
    private final MovieService movieService;

    /* Payment service for accessing the table of payments */
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(
            TicketService ticketService,
            SeatService seatService,
            MovieService movieService,
            PaymentService paymentService
    ) {
        this.ticketService = ticketService;
        this.seatService = seatService;
        this.movieService = movieService;
        this.paymentService = paymentService;
    }

    /* Get all available movies at the theater */
    @GetMapping
    public List<Payment> getPayments() {
        return paymentService.getAllPayments();
    }
}
