package com.unaiz.dao;

import com.unaiz.entity.Student;

import java.util.List;

public interface StudentDAO {

    void saveStudent(Student student);

    Student getStudent(int id);

    List<Student> getAllStudents();

    void deleteStudent(int id);

}
