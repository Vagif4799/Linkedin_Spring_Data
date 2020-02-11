package com.linkedin_spring_data.model;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer id;

    @Column(name = "course_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_dept_id")
    private Department department;

    public Course(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
