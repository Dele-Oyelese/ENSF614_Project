package com.movie.moviebackend.repository;

import com.movie.moviebackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
    //
}
