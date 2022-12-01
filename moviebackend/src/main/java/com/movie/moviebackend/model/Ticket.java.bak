package com.movie.moviebackend.model;


import javax.persistence.*;

@Entity
@Table
public class Ticket {

    @Id
    @SequenceGenerator(name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_sequence"
    )
    private Long id;
    private Long seatNum;
    private double price;
    private String buyerStatus;
    private String movieName;


}
