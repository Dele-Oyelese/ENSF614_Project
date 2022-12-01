package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;
import com.example.demo.course.Course;

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

@RestController
@RequestMapping("api/v1/student")
@CrossOrigin
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
	public List<Student> getStudents(){
		return studentService.getStudents();
	}

    @GetMapping("/{studentId}")
    public Student getStudient(@PathVariable(required = false) Long studentId) {
        return studentService.getStudentById(studentId);
    }

    // @GetMapping("/{studentId}/enrolledcourses")
    // public Set<Course> getEnrolledCourses(@PathVariable Long studentId){
    //     return studentService.getEnrolledCourses(studentId);
    // }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @PutMapping(path="{studentid}")
    public void updateStudent(
            @PathVariable("studentid") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }

    @DeleteMapping(path="{studentid}")
    public void deleteStudent(@PathVariable("studentid") Long studentId){
        studentService.deleteStudent(studentId);

    }

    // @PutMapping("/{studentId}/course/{courseId}")
    // public Student assignCoursetoStudent(
    //         @PathVariable Long studentId,
    //         @PathVariable Long courseId
    // ){
    //     return studentService.assignCoursetoStudent(studentId, courseId);
    // }
}

    
    

