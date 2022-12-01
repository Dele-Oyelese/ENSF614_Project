package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }


    public List<Student> getStudents(){
		return studentRepository.findAll();
	}

    public void addNewStudent(Student student){
        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());

        if(studentEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);

        System.out.println(student);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email){
        
        // find student by id, throw error if it doesn't exist
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new IllegalStateException("Student does not exist!"));

        // make sure name is not null, > 0, and not the same as before
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        // make sure email is not null, >0, and not already in db
        if(email!= null && email.length() > 0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional  = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

        studentRepository.save(student);

    }

    // public List<Student> getStudentDetails(Long studentId) {
    //     if (null != studentId) {
    //         return studentRepository.findAllBystudentId(studentId);
    //     } else {
    //         return studentRepository.findAll();
    //     }
    // }

    public Student getStudentById(Long studentId) {
        Optional<Student> studentById = studentRepository.findById(studentId);
        if (!studentById.isPresent()) {
            throw new IllegalStateException("Student ID does not exist");
        }
        return studentById.get();
    }

    // public Set<Course> getEnrolledCourses(Long studentId){
    //     Set<Course> courseSet = null;

    //     Student student = studentRepository.findById(studentId).get();
    //     courseSet = student.getCourses();
    //     return courseSet;
    // }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id " + studentId + " does not exist!");

        }

        studentRepository.deleteById(studentId);

    }


    // public Student assignCoursetoStudent(Long studentId, Long courseId) {
    //     Set<Course> courseSet = null;

    //     Student student = studentRepository.findById(studentId).get();
    //     Course course = courseRepository.findById(courseId).get();
    //     courseSet =  student.getCourses();
    //     courseSet.add(course);
    //     student.setCourses(courseSet);
    //     return studentRepository.save(student);
    // }

    
}
