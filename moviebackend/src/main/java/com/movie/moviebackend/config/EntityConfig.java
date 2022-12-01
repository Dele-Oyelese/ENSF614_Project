package com.movie.moviebackend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import com.movie.moviebackend.model.RegisteredUser;
import com.movie.moviebackend.model.Movie;
import com.movie.moviebackend.model.Seat;
import com.movie.moviebackend.model.Ticket;
import com.movie.moviebackend.repository.MovieRepo;
import com.movie.moviebackend.repository.RegisteredUserRepo;
import com.movie.moviebackend.repository.SeatRepo;
import com.movie.moviebackend.repository.TicketRepo;



@Configuration
public class EntityConfig {

        @Bean
        CommandLineRunner commandLineRunner3(RegisteredUserRepo userRepo){
            return args -> {

                RegisteredUser user1= new RegisteredUser("John", "Uni Ave", 1231, "John@Daly.com", "123er5");
                RegisteredUser user2= new RegisteredUser("Andrew", "Airdire", 1212231, "Andrew@Daly.com", "abcd");
                RegisteredUser user3= new RegisteredUser("Dhruvi", "Crowfoot", 44423, "Dhruvi@Daly.com", "bhdft");
                RegisteredUser user4= new RegisteredUser("Ryan", "Okotoks", 121231, "Ryan@Daly.com","lopsrtgy");
                RegisteredUser user5= new RegisteredUser("Dele", "WestBrook", 7787, "Dele@Daly.com","kskhdp");

                userRepo.saveAll(List.of(user1,user2,user3,user4,user5));
            };
        }

        @Bean
        CommandLineRunner commandLineRunner4(MovieRepo movieRepo)
        {
            return args -> {
                Movie m1 = new Movie("Shrek 5", "14:00");
                Movie m2 = new Movie("Shrek 5", "17:45");
                Movie m3 = new Movie("Shrek 5", "21:00");

                Movie m4 = new Movie("The Room 2: Electric Boogaloo", "11:00");

                Movie m5 = new Movie("Napoleon Dynamite 2", "07:15");

                Movie m6 = new Movie("Hot Rod 2", "15:30");

                movieRepo.saveAll(List.of(
                        m1,
                        m2,
                        m3,
                        m4,
                        m5,
                        m6
                ));
            };
        }
}
