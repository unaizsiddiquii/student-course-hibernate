package com.unaiz.service;

import com.unaiz.entity.Student;

import java.util.List;

public interface StudentService {
    void registerStudent(Student student);

    Student getStudentById(int id);

    List<Student> getAllStudents();

    void deleteStudent(int id);
}
