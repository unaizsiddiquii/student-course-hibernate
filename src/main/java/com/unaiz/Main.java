package com.unaiz;


import com.unaiz.entity.Student;
import com.unaiz.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Step 3: Create Student
            Student student = new Student("Unaiz", "unaiz@example.com");

            // Step 4: Begin Transaction
            session.beginTransaction();

            // Step 5: Save the object
            session.persist(student);

            // Step 6: Commit
            session.getTransaction().commit();

            System.out.println("✅ Student Saved: " + student.getId());

        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
