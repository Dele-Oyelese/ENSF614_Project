package com.example.demo.course;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseConfig {

    @Bean
    CommandLineRunner commandLineRunner2(CourseRepository repository){
        return args -> {
            // Course ensf609 = new Course("ENSF609");
            // Course ensf608 = new Course("ENSF608");
            // Course ensf610 = new Course("ENSF610");
            // Course ensf611 = new Course("ENSF611");
            // Course ensf612 = new Course("ENSF612");
            // Course ensf614 = new Course("ENSF614");
            // Course ensf613 = new Course("ENSF613");

            // repository.saveAll(List.of(ensf608,ensf609,ensf610,ensf611,ensf612,ensf613,ensf614));

        };
    }
}
