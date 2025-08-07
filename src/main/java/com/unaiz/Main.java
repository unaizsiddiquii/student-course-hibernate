package com.unaiz;


import com.unaiz.entity.Address;
import com.unaiz.entity.Course;
import com.unaiz.entity.Student;
import com.unaiz.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Course java = new Course("Java", 60);
            Course python = new Course("Python", 40);

            Student student = new Student("Kunal", "kunal@code.com");
            student.addCourse(java);
            student.addCourse(python);

            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
            System.out.println("✅ Student with courses saved");
        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
