package com.movie.moviebackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.movie.moviebackend.MovieView;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


//
//    @OneToMany(mappedBy = "movie")
//    // @JsonManagedReference
//    // @JsonIgnore
//    @JsonView(MovieView.FullData.class)
//    @JsonIgnoreProperties("movie")
//    Set<Seat> seats;

    /*
    Need to implement a @ManyToMany hashset if we include
    multiple theaters with the same movie
     */

    private boolean seat1 = true;

    private boolean seat2 = true;;

    private boolean seat3= true;

    private boolean seat4= true;

    private boolean seat5= true;

    private boolean seat6= true;

    private boolean seat7= true;

    private boolean seat8 = true;

    private boolean seat9 = true;

    private boolean seat10 = true;




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

    public Movie(){
    }

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

    public boolean isSeat1() {
        return seat1;
    }

    public void setSeat1(boolean seat1) {
        this.seat1 = seat1;
    }

    public boolean isSeat2() {
        return seat2;
    }

    public void setSeat2(boolean seat2) {
        this.seat2 = seat2;
    }

    public boolean isSeat3() {
        return seat3;
    }

    public void setSeat3(boolean seat3) {
        this.seat3 = seat3;
    }

    public boolean isSeat4() {
        return seat4;
    }

    public void setSeat4(boolean seat4) {
        this.seat4 = seat4;
    }

    public boolean isSeat5() {
        return seat5;
    }

    public void setSeat5(boolean seat5) {
        this.seat5 = seat5;
    }

    public boolean isSeat6() {
        return seat6;
    }

    public void setSeat6(boolean seat6) {
        this.seat6 = seat6;
    }

    public boolean isSeat7() {
        return seat7;
    }

    public void setSeat7(boolean seat7) {
        this.seat7 = seat7;
    }

    public boolean isSeat8() {
        return seat8;
    }

    public void setSeat8(boolean seat8) {
        this.seat8 = seat8;
    }

    public boolean isSeat9() {
        return seat9;
    }

    public void setSeat9(boolean seat9) {
        this.seat9 = seat9;
    }

    public boolean isSeat10() {
        return seat10;
    }

    public void setSeat10(boolean seat10) {
        this.seat10 = seat10;
    }
}
