package com.movie.moviebackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "box_office")
public class BoxOffice {



    @EmbeddedId
    private TransactionKey id = new TransactionKey();

    public TransactionKey getId(){return id;}

    public void setId(TransactionKey id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("ticketId")
    @JoinColumn(name = "ticket_id",nullable = false)
    // @JsonBackReference
    @JsonIgnoreProperties("boxOffices")
    Ticket ticket;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id", nullable = false)
    // @JsonBackReference
    @JsonIgnoreProperties("boxOffices")
    Movie movie;

    public BoxOffice(){}

    public BoxOffice(TransactionKey id, Ticket ticket, Movie movie){
        this.id =id;
        this.ticket =ticket;
        this.movie = movie;
    }

    public BoxOffice( Ticket ticket, Movie movie){
        this.ticket =ticket;
        this.movie = movie;
    }
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
