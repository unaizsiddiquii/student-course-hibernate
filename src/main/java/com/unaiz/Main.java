package com.unaiz;


import com.unaiz.entity.Address;
import com.unaiz.entity.Course;
import com.unaiz.entity.Department;
import com.unaiz.entity.Student;
import com.unaiz.service.StudentService;
import com.unaiz.service.StudentServiceImpl;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentService studentService = new StudentServiceImpl();

        while (true) {
            System.out.println("\n ***STUDENT-COURSE-MANAGEMENT*** (Hibernate)");
            System.out.println("1. Add Student with Courses");
            System.out.println("2. View All Students");
            System.out.println("3. View Students By Id");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudentWithCourses(scanner, studentService);
                    break;
                case 2:
                    viewAllStudents(studentService);
                    break;
                case 3:
                    viewStudentById(scanner, studentService);
                    break;

                case 4: {
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                }
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addStudentWithCourses(Scanner scanner, StudentService studentService) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        Student student = new Student();
        student.setName(studentName);

        System.out.print("Enter student email: ");
        String studentEmail = scanner.nextLine();
        student.setEmail(studentEmail);

        System.out.print("Enter student Department: ");
        String studentDepartment = scanner.nextLine();
        student.setDepartment(new Department(studentDepartment));

        System.out.println("Enter Address: ");
        System.out.println("City: ");
        String city = scanner.nextLine();
        System.out.println("State: ");
        String state = scanner.nextLine();
        System.out.println("Pincode: ");
        String pincode = scanner.nextLine();

        student.setAddress(new Address(city, state, pincode));

        System.out.print("How many courses to assign? ");
        int courseCount = scanner.nextInt();
        scanner.nextLine(); // consume newline


        for (int i = 1; i <= courseCount; i++) {
            System.out.print("Enter course " + i + " title: ");
            String title = scanner.nextLine();

            Course course = new Course();
            course.setTitle(title);
            student.addCourse(course); // handles both sides of relation
        }

        studentService.registerStudent(student);
        System.out.println(student.toString());
        System.out.println("Student saved successfully with courses.");
    }

    private static void viewAllStudents(StudentService studentService) {
        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println("Student: " + s.getName());
                for (Course c : s.getCourses()) {
                    System.out.println("Course: " + c.getTitle());
                }
            }
        }

    }

    private static void viewStudentById(Scanner scanner, StudentService studentService) {
        System.out.println("Enter Student id");
        int id = scanner.nextInt();

        Student student = studentService.getStudentById(id);
        System.out.println(student.toString());


    }

}
