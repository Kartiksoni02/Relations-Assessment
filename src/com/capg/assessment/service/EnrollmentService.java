package com.capg.assessment.service;

import javax.persistence.*;
import com.capg.assessment.entity.*;

public class EnrollmentService {

    private EntityManager em;

    public EnrollmentService(EntityManager em) {
        this.em = em;
    }

    public void enrollStudent(Long studentId, Long courseId) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Student student = em.find(Student.class, studentId);
            Course course = em.find(Course.class, courseId);

            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);

            em.persist(enrollment);

            tx.commit();
            System.out.println("Student Enrolled Successfully!");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public void assignGrade(Long enrollmentId, String grade) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Enrollment enrollment = em.find(Enrollment.class, enrollmentId);
            enrollment.setGrade(grade);

            tx.commit();
            System.out.println("Grade Assigned Successfully!");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}