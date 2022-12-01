package com.example.demo.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.student.StudentRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long courseId) {
        Optional<Course> courseById = courseRepository.findById(courseId);
        if (!courseById.isPresent()) {
            throw new IllegalStateException("Course doesn't exist!");
        }
        return courseById.get();
    }

    public void removeCourse(Long id) {
        Optional<Course> courseById = courseRepository.findById(id);
        if (courseById.isPresent() == false) {
            throw new IllegalStateException("Course not found!");
        }
        courseRepository.deleteById(id);
    }

    public Course getCourseByName(String coursename) {
        Optional<Course> courseByName = courseRepository.findCourseByName(coursename);
        if (!courseByName.isPresent()) {
            throw new IllegalStateException("Course does not exisdt!");
        }
        return courseByName.get();

    }

    // public void addNewCourse(Course course){
    // Optional<Course> courseByName =
    // courseRepository.findByName(course.getName());
    // if (courseByName.isPresent()) {
    // throw new IllegalStateException("Course already exist!");
    // }
    // courseRepository.save(course);

    // }

}
