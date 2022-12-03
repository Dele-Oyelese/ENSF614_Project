package com.movie.moviebackend.model;


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

    /* Define this as a foreign key somehow? */
    /* TODO: cascade delete */
    private Long movieId;

    /* In the following format: C01, E28, A12, etc. */
    private String seatNum;

    /* Price of the movie seat */
    private double price;
    @Transient
    private boolean available;

    public Seat(){
        this.available = true;
    }
    public Seat(Long id, Long movieId, String seatNum, double price){
        this.id = id;
        this.available = available;
    }

    public Seat(Long movieId, String seatNum, double price)
    {
        this.movieId = movieId;
        this.seatNum = seatNum;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
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
