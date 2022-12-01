package com.movie.moviebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.movie.moviebackend.MovieView;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie  {
    @Id
    @SequenceGenerator(name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    @JsonView(MovieView.id.class)
    private Long id;

    @JsonView(MovieView.CoreData.class)
    private String title;

    private String showTime;

    @OneToMany(mappedBy = "movie")
    // @JsonManagedReference
    // @JsonIgnore
    @JsonIgnoreProperties("movie")
    @JsonView(MovieView.FullData.class)
    Set<BoxOffice> boxOffices;


    /*
    Need to implement a @ManyToMany hashset if we include
    multiple theaters with the same movie
     */


    public void addTicket(BoxOffice b){boxOffices.add(b);}
    public void removeTicket(BoxOffice b){boxOffices.remove(b);}

    @Override
    public boolean equals(Object that){
        if(this.getClass() != that.getClass()){
            return false;
        }

        Movie m = (Movie) that;
        return (this.getId() == m.getId() && this.getTitle().equals(m.getTitle()));

    }


    public Movie(){}

    public Movie(Long id, String title, String showTime)
    {
        this.id = id;
        this.title = title;
        this.showTime = showTime;
    }

    public Movie(String title, String showTime)
    {
        this.title = title;
        this.showTime = showTime;
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

    public Set<BoxOffice> getBoxOffices() {
        return boxOffices;
    }

    public void setBoxOffices(Set<BoxOffice> boxOffices) {
        this.boxOffices = boxOffices;
    }

}
