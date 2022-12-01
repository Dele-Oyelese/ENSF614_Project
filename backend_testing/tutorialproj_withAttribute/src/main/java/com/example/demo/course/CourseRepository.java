package com.example.demo.course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    // Optional<Course> findByName(String name);

    // List<Course> findCoursebyid(Long courseId);

    Optional<Course> findCourseByName(String name);
    
}
