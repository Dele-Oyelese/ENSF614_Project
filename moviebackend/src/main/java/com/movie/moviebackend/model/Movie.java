package com.movie.moviebackend.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    @SequenceGenerator(name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long id;

    private String title;

    private String showTime;

    private Integer numSeats;

    /*
    Need to implement a @ManyToMany hashset if we include
    multiple theaters with the same movie
     */

    public Movie(){}

    public Movie(Long id, String title, String showTime, Integer numSeats)
    {
        this.id = id;
        this.title = title;
        this.showTime = showTime;
        this.numSeats = numSeats;
    }

    public Movie(String title, String showTime, Integer numSeats)
    {
        this.title = title;
        this.showTime = showTime;
        this.numSeats = numSeats;
    }

    /* Getters and setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
