package com.example.demo.registration;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo.course.Course;
import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Registration {

    @EmbeddedId
    private CourseGradeKey id = new CourseGradeKey();

    public CourseGradeKey getId() {
        return id;
    }

    public void setId(CourseGradeKey id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    // @JsonBackReference
    @JsonIgnoreProperties({"registrations"})
    Student student;
    
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    // @JsonBackReference
    @JsonIgnoreProperties("registrations")
    Course course;

    @Column(name = "grade")
    int grade;

    public Registration(CourseGradeKey id, Student student, Course course, int grade) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    public Registration() {
    }

    public Registration(Student student, Course course, int grade) {
        this.student = student;
        this.course = course;
        this.grade = 0;
    }



    public Registration(Student student2, Course course2) {
        this.course = course2;
        this.student = student2;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



    

}
