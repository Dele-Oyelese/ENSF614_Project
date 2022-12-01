package com.example.demo.registration;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CoursesView;
import com.example.demo.course.Course;
import com.example.demo.course.CourseService;
import com.example.demo.student.Student;
import com.example.demo.student.StudentService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(path="api/v1/registration")
@CrossOrigin
public class RegistrationController {

    private final RegistrationService registrationService;
    private final CourseService courseService;
    private final StudentService studentService;

    @Autowired
    public RegistrationController(RegistrationService registrationService,
    CourseService courseService, StudentService studentService){
        this.registrationService = registrationService;
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @GetMapping
    public List<Registration> getAllRegistration(){
        return registrationService.getAllRegistration();
    }

    // @PostMapping
    // public void registerStudentInCourse(@RequestBody Registration r){
    //     registrationService.registerStudentInCourse(r);
        
    // }

    @GetMapping("/{studentId}/registeredIn/")
    @JsonView(CoursesView.CoreData.class)
    public List<Course> getStudentCoursesRegisteredIn(@PathVariable(required = false) Long studentId) {
        return registrationService.getStudentCoursesRegisteredIn(studentId);
    }

    @PutMapping("/register/{studentId}/enrolledcourses/{courseId}")
    public void registerStudentInCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId
    ) {
        registrationService.registerStudentInCourse(studentId, courseId);
    }

    @PutMapping("/register/{studentId}/deRegister/{courseId}")
    public void deregisterStudentInCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId
    ) {
        registrationService.deregisterStudentInCourse(studentId, courseId);
    }

    
    
}
