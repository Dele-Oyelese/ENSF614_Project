package com.example.demo.registration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.course.Course;
import com.example.demo.course.CourseRepository;
import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;

@Service
public class RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository, StudentRepository studentRepository, CourseRepository courseRepository){
        this.registrationRepository = registrationRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }



    public List<Registration> getAllRegistration() {
        return registrationRepository.findAll();
    }



    public void registerStudentInCourse(Long studentId, Long courseId) {
        // Optional<Registration> reg = registrationRepository.findById(r.getId());
        // if (reg.isPresent()) {
        //     throw new IllegalStateException("Already registered!");
        // }
        
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();

        if (student.getRegistrations().size() >=6){
            throw new IllegalStateException("Student is allowed a maximum of 6 courses.");
        }

        Registration r = new Registration(student,course);
        r.setStudent(student);
        r.setCourse(course);

        course.addStudent(r);
        student.addCourses(r);

        
        registrationRepository.save(r);

    }



    public List<Course> getStudentCoursesRegisteredIn(Long studentId) {
        
        Student student = studentRepository.findById(studentId).get();
        Set<Registration> myRegistrations = student.getRegistrations();
        List<Course> myCourses = new ArrayList<Course>();

        for(Registration r : myRegistrations){
            Course c = r.getCourse();
            myCourses.add(c);
        }

        return myCourses;

    }



    public void deregisterStudentInCourse(Long studentId, Long courseId) {

        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();

        Set<Registration> regs = new HashSet<Registration>();
        
        for(Registration r:student.getRegistrations()){
            regs.add(r);
        }

        boolean courseFound = false;

        for(Registration r: regs){
            if(r.getCourse().equals(course)){
                student.removeCourse(r);
                course.removeStudent(r);
                courseFound = true;
                registrationRepository.delete(r);
            }
        }
        if(!courseFound){
            throw new IllegalStateException("Course to remove student from was not found");
        }


    }
   
}
