package com.unaiz;


import com.unaiz.entity.Address;
import com.unaiz.entity.Course;
import com.unaiz.entity.Department;
import com.unaiz.entity.Student;
import com.unaiz.service.StudentService;
import com.unaiz.service.StudentServiceImpl;
import com.unaiz.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Student student = new Student("Zaheer", "zaheer@demo.com");
            student.setAddress(new Address("Lucknow", "UP", "226001"));
            student.setDepartment(new Department("ECE"));

            Course java = new Course("Java", 60);
            Course sql = new Course("SQL", 40);
            student.addCourse(java);
            student.addCourse(sql);

            StudentService service = new StudentServiceImpl();
            service.registerStudent(student);

            System.out.println("Student registered with service layer");

            System.out.println("Student with courses saved");
        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
