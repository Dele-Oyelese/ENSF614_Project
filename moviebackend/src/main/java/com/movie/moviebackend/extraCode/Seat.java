package com.movie.moviebackend.extraCode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.movie.moviebackend.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;







@Data
@AllArgsConstructor

@ToString
@Entity
public class Seat {


    @EmbeddedId
    private SeatKey id = new SeatKey();

    public SeatKey getId(){return id;}

    public void setId(SeatKey id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movieId",nullable = false)
    @JsonIgnoreProperties("seats")
    Movie movie;
    private int seatNum;
    private boolean availability;


    public Seat(){}

    public Seat(SeatKey id,  Movie movie){
        this.id =id;
        this.movie = movie;
    }

    public Seat( Movie movie){
        this.movie = movie;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }


}
