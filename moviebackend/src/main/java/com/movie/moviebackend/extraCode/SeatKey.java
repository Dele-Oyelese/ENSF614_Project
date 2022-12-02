package com.movie.moviebackend.extraCode;

import javax.persistence.Column;
import java.io.Serializable;

public class SeatKey implements Serializable {


        @Column(name = "movie_id")
        Long movieId;

        public SeatKey(Long movieId) {
            this.movieId = movieId;
        }

        public SeatKey(){}
    }


