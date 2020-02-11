package com.linkedin_spring_data.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Integer id;

    @Column(name = "dept_name")
    private String name;

    @OneToMany(
            mappedBy = "department",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Course> courses = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
