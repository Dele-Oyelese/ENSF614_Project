package com.movie.moviebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.swing.*;
import java.util.Set;

//Create Ticket as a entity class and a table
@Entity
@Table(name = "ticket")
public class Ticket {
//Auto Generate ticket sequence
    @Id
    @SequenceGenerator(name = "ticket_sequence",
            sequenceName = "ticket_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ticket_sequence"
    )
    private Long id;
    private int seatNum;
    private double price;
    private boolean buyerStatus;
    private String movieName;
    private Long mId;

    // Map one tickey yo many BoxOffices
    @OneToMany(mappedBy = "ticket")
    @JsonIgnoreProperties("ticket")
    private Set<BoxOffice> boxOffices;

    //Default Constructor
    Ticket(){}
//Ticket constructor with ID
    public Ticket(Long id, int seatNum, Double price, boolean buyerStatus, String movieName){

        this.id =id;
        this.buyerStatus =buyerStatus;
        this.seatNum = seatNum;
        this.price =price;
        this.movieName =movieName;

    }
//Ticket Constructor no ID
    public Ticket(int seatNum, Double price, boolean buyerStatus, String movieName){
        this.buyerStatus =buyerStatus;
        this.seatNum = seatNum;
        this.price =price;
        this.movieName =movieName;
    }
// Add movies to boxOffice Set
    public void addMovie(BoxOffice b) {
        boxOffices.add(b);
    }
//Remove Movies from boxOffice Set
    public void removeMovie(BoxOffice r){
        boxOffices.remove(r);
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBuyerStatus() {
        return buyerStatus;
    }

    public void setBuyerStatus(boolean buyerStatus) {
        this.buyerStatus = buyerStatus;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Set<BoxOffice> getBoxOffices() {
        return boxOffices;
    }

    public void setBoxOffices(Set<BoxOffice> boxOffices) {
        this.boxOffices = boxOffices;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }
}
