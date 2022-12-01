package com.movie.moviebackend.repository;

import com.movie.moviebackend.model.BoxOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxOfficeRepo extends JpaRepository<BoxOffice, Long> {
}
