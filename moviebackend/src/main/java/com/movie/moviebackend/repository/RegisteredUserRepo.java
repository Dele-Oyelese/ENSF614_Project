package com.movie.moviebackend.repository;

import com.movie.moviebackend.model.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RegisteredUserRepo extends JpaRepository<RegisteredUser, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<RegisteredUser> findUserByEmail(String email);


}
