package com.movie.moviebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.swing.*;
import java.util.Set;

@Entity
@Table(name = "ticket")
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
    private String seatNum;
    private double price;
    private boolean buyerStatus;
    private String movieName;

    @OneToMany(mappedBy = "ticket")

    @JsonIgnoreProperties("ticket")

    Set<BoxOffice> boxOffices;

    Ticket(){}

    public Ticket(Long id, String seatNum, Double price, boolean buyerStatus, String movieName){

        this.id =id;
        this.buyerStatus =buyerStatus;
        this.seatNum = seatNum;
        this.price =price;
        this.movieName =movieName;

    }

    public Ticket(String seatNum, Double price, boolean buyerStatus, String movieName){
        this.buyerStatus =buyerStatus;
        this.seatNum = seatNum;
        this.price =price;
        this.movieName =movieName;
    }

    public void addMovie(BoxOffice b) {
        boxOffices.add(b);
    }

    public void removeMovie(BoxOffice r){
        boxOffices.remove(r);
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




}
