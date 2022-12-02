package com.movie.moviebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


// Initate BoxOffice class as entity
@Entity
@Table(name = "box_office")
public class BoxOffice {

    //embedded Priamry key as a combination of Ticket and Movie ID's (Transaction Key)
    @EmbeddedId
    private TransactionKey id = new TransactionKey();
    // Transaction key getter and setters
    public TransactionKey getId(){return id;}
    public void setId(TransactionKey id) {
        this.id = id;
    }

    //Map Many box offices to One Ticket
    @ManyToOne
    @MapsId("ticketId")
    @JoinColumn(name = "ticket_id",nullable = false)
    @JsonIgnoreProperties("boxOffices")
    Ticket ticket;
    // Map many boxOffices to one Movie
    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id", nullable = false)
    // @JsonBackReference
    @JsonIgnoreProperties("boxOffices")
    Movie movie;

    //Default Constructor
    public BoxOffice(){}
//Constructor with Transaction Key
    public BoxOffice(TransactionKey id, Ticket ticket, Movie movie){
        this.id =id;
        this.ticket =ticket;
        this.movie = movie;
    }
//Constructor without Transaction Key
    public BoxOffice( Ticket ticket, Movie movie){
        this.ticket =ticket;
        this.movie = movie;
    }

    //Getters and setters
    public Ticket getTicket() {
        return ticket;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
