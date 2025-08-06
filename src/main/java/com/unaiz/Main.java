package com.unaiz;


import com.unaiz.entity.Address;
import com.unaiz.entity.Student;
import com.unaiz.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Address address = new Address("Mumbai", "MH", "400001");
            Student student = new Student("Khushi Siddiqui", "khuhsi0726@gmail.com");
            student.setAddress(address);
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();

        } catch (Exception e) {
            if (session.getTransaction() != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
