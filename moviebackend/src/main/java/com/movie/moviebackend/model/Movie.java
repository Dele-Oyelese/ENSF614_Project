package com.movie.moviebackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.movie.moviebackend.MovieView;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


// Create a Movie Entity class table
@Entity
@Table(name = "movie")
public class Movie  {


//    Auto Generate ID of movie
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
// add a view for movie title
    @JsonView(MovieView.CoreData.class)
    private String title;


// Movie to a box office table ignoring the movie self referencing
    @OneToMany(mappedBy = "movie")
    @JsonIgnoreProperties("movie")
    @JsonView(MovieView.FullData.class)
    private Set<BoxOffice> boxOffices;

    //    Add showtimes
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime showTime;



// Initialize all seats availability to true
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




    //Ability to add a ticket to the Movies Box Office
    public void addTicket(BoxOffice b){boxOffices.add(b);}
//Ability to remove a ticket from movies boxOffice
    public void removeTicket(BoxOffice b){boxOffices.remove(b);}

//Override equals for title comparison
    @Override
    public boolean equals(Object that){
        if(this.getClass() != that.getClass()){
            return false;
        }

        Movie m = (Movie) that;
        return (this.getId() == m.getId() && this.getTitle().equals(m.getTitle()));

    }
//Default constructor
    public Movie(){
    }
// Constructor with ID Title and Showtime
    public Movie(Long id, String title, LocalDateTime showTime)
    {
        this.id = id;
        this.title = title;
        this.showTime = showTime;


    }

    public Movie(Long id, String title)
    {
        this.title = title;
        this.id = id;
        this.showTime = LocalDateTime.now();
    }

    //Constructor without ID
    public Movie(String title, LocalDateTime showTime)
    {
        this.title = title;
        this.showTime = showTime;
    }

    public Movie(String title)
    {
        this.title = title;
        this.showTime = LocalDateTime.now();
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

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
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
