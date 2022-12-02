package com.movie.moviebackend.repository;

import com.movie.moviebackend.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Initiate User Repository as a JPA Repository
@Repository
public interface RegisteredUserRepo extends JpaRepository<RegisteredUser, Long> {

    //Additional Query to find User by email
    @Query("SELECT s FROM RegisteredUser s WHERE s.email = ?1")
    Optional<RegisteredUser> findUserByEmail(String email);


}
