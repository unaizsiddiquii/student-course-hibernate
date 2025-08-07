package com.unaiz.util;

import com.unaiz.entity.Address;
import com.unaiz.entity.Course;
import com.unaiz.entity.Department;
import com.unaiz.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Department.class)
                    .addAnnotatedClass(Course.class)
                    .buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
