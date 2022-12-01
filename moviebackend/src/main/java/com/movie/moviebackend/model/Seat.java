package com.movie.moviebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name ="seat")
public class Seat {

    @Id
    @SequenceGenerator(name = "seat_sequence",
            sequenceName = "seat_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seat_sequence"
    )
    private Long id;



    /* In the following format: C01, E28, A12, etc. */
    private String seatNum;

    /* Price of the movie seat */
    private double price;
    @Transient
    private boolean available;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id", nullable = false)
    // @JsonBackReference
    @JsonIgnoreProperties("seat")
    Movie movie;



    public Seat(){
        this.available = true;
    }
    public Seat(Long id, Long movieId, String seatNum, double price){
        this.id = id;
        this.available = true;
    }

    public Seat( String seatNum, double price, Movie movie)
    {
        this.movie =movie;
        this.seatNum = seatNum;
        this.price = price;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
