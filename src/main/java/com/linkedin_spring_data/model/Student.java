package com.linkedin_spring_data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

//    @Column(name = "student_name", nullable = false)
//    private String name;

    @Column(name = "student_fulltime", nullable = false)
    private boolean fullTime;

    @Column(name = "student_age")
    private Integer age;

    @Embedded
    private Person attendee;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Enrollment",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private List<Course> courses = new ArrayList<>();


    public Student(boolean fullTime, Integer age, Person attendee, List<Course> courses) {
        this.fullTime = fullTime;
        this.age = age;
        this.attendee = attendee;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getAttendee() {
        return attendee;
    }

    public void setAttendee(Person attendee) {
        this.attendee = attendee;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
