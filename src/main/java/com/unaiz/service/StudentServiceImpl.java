package com.unaiz.service;

import com.unaiz.dao.StudentDAO;
import com.unaiz.dao.StudentDAOImpl;
import com.unaiz.entity.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public void registerStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
