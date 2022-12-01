package com.example.demo.course;

import com.example.demo.registration.Registration;
import com.example.demo.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import com.example.demo.CoursesView;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @JsonView(CoursesView.id.class)
    private Long id;

    @JsonView(CoursesView.CoreData.class)
    private String name;

    @OneToMany(mappedBy = "course")
    // @JsonManagedReference
    // @JsonIgnore
    @JsonIgnoreProperties("course")
    @JsonView(CoursesView.FullData.class)
    Set<Registration> registrations;


    // @JsonIgnore
    // @ManyToMany(mappedBy = "courses")
    // private Set<Student> students = new HashSet<>();

    // public Set<Student> getStudents() {
    //     return students;
    // }

    // public void setStudents(Set<Student> students) {
    //     this.students = students;
    // }

    public void addStudent(Registration r) {
        registrations.add(r);
      }
      
    //   public void removeStudent(long studentId) {
    //     Student student = this.students.stream().filter(t -> t.getId() == studentId).findFirst().orElse(null);
    //     if (student != null) {
    //       this.students.remove(student);
    //       student.getCourses().remove(this);
    //     }
    //   }

    @Override
    public boolean equals(Object that){
        if(this.getClass() != that.getClass()){
            return false;
        }

        Course c = (Course) that;
        return (this.getId() == c.getId() && this.getName().equals(c.getName()));

    }
    

    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    public void removeStudent (Registration r){
        registrations.remove(r);
    }

    public Course() {
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

}
