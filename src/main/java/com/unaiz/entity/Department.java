package com.unaiz.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setDepartment(this); // sync both sides
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
