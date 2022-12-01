package com.example.demo.registration;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
class CourseGradeKey implements Serializable {

    @Column(name = "student_id")
    Long studentId;

    @Column(name = "course_id")
    Long courseId;


    public CourseGradeKey(Long courseId, Long studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    public CourseGradeKey() {
    }

    

    // public Long getStudentId() {
    //     return studentId;
    // }

    // public void setStudentId(Long studentId) {
    //     this.studentId = studentId;
    // }

    // public Long getCourseId() {
    //     return courseId;
    // }

    // public void setCourseId(Long courseId) {
    //     this.courseId = courseId;
    // }



}