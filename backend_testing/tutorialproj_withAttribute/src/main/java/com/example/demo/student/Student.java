package com.example.demo.student;

import com.example.demo.course.Course;
import com.example.demo.registration.Registration;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",
                        sequenceName = "student_sequence",
                        allocationSize = 1)
    @GeneratedValue(
                    strategy = GenerationType.SEQUENCE,
                    generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy="student")
    // @JsonIgnore
    // @JsonManagedReference
    @JsonIgnoreProperties("student")
    Set<Registration> registrations;

    // @ManyToMany()
    // @JoinTable(name = "student_course",
    // joinColumns = { @JoinColumn(name = "student_id") },
    // inverseJoinColumns = { @JoinColumn(name = "course_id") })
    // private Set<Course> courses = new HashSet<>();

    // public Set<Course> getCourses() {
    //     return courses;
    // }

    // public void setCourses(Set<Course> courses) {
    //     this.courses = courses;
    // }

    public void addCourses(Registration r) {
        registrations.add(r);
      }

    public void removeCourse(Registration r){
        registrations.remove(r);
    }
    
    //   public void removeCourse(long courseId) {
    //     Course course = this.courses.stream().filter(t -> t.getId() == courseId).findFirst().orElse(null);
    //     if (course != null) {
    //       this.courses.remove(course);
    //       course.getStudents().remove(this);
    //     }
    //   }




    public Set<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(Set<Registration> registrations) {
        this.registrations = registrations;
    }

    @Transient
    private Integer age;

    public Student() {
    }

    public Student(String name, String email, LocalDate dob, String password) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.password = password;
    }

    public Student(Long id, String name, String email, LocalDate dob, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
    }

}
