package com.capg.assessment.application;

import java.util.*;
import javax.persistence.*;

import com.capg.assessment.service.*;
import com.capg.assessment.entity.*;

public class UniversityApplication {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("universityPU");

        EntityManager em = emf.createEntityManager();

        StudentService studentService = new StudentService(em);
        FacultyService facultyService = new FacultyService(em);
        CourseService courseService = new CourseService(em);
        EnrollmentService enrollmentService = new EnrollmentService(em);
        ReportService reportService = new ReportService(em);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== UNIVERSITY MENU =====");
            System.out.println("1. Register Student");
            System.out.println("2. Add Faculty");
            System.out.println("3. Create Course");
            System.out.println("4. Assign Faculty to Course");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. Assign Grade");
            System.out.println("7. View Student Report");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    studentService.registerStudent(name, email);
                    break;

                case 2:
                    System.out.print("Faculty Name: ");
                    String facultyName = sc.nextLine();

                    System.out.print("Department: ");
                    String dept = sc.nextLine();

                    facultyService.addFaculty(facultyName, dept);
                    break;

                case 3:
                    System.out.print("Course Title: ");
                    String title = sc.nextLine();

                    System.out.print("Credits: ");
                    int credits = sc.nextInt();
                    sc.nextLine();

                    courseService.createCourse(title, credits);
                    break;

                case 4:
                    System.out.print("Course ID: ");
                    Long courseId = sc.nextLong();

                    System.out.print("Faculty ID: ");
                    Long facultyId = sc.nextLong();
                    sc.nextLine();

                    courseService.assignFaculty(courseId, facultyId);
                    break;

                case 5:
                    System.out.print("Student ID: ");
                    Long studentId = sc.nextLong();

                    System.out.print("Course ID: ");
                    Long enrollCourseId = sc.nextLong();
                    sc.nextLine();

                    enrollmentService.enrollStudent(studentId, enrollCourseId);
                    break;

                case 6:
                    System.out.print("Enrollment ID: ");
                    Long enrollmentId = sc.nextLong();
                    sc.nextLine();

                    System.out.print("Grade: ");
                    String grade = sc.nextLine();

                    enrollmentService.assignGrade(enrollmentId, grade);
                    break;

                case 7:
                    System.out.print("Student ID: ");
                    Long reportStudentId = sc.nextLong();
                    sc.nextLine();

                    reportService.getStudentReport(reportStudentId);
                    break;

                case 8:
                    em.close();
                    emf.close();
                    System.out.println("Exiting University System...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}