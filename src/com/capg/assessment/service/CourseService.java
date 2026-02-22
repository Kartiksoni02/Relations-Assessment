package com.capg.assessment.service;

import javax.persistence.*;
import com.capg.assessment.entity.*;

public class CourseService {

    private EntityManager em;

    public CourseService(EntityManager em) {
        this.em = em;
    }

    public void createCourse(String title, int credits) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Course course = new Course();
            course.setTitle(title);
            course.setCredits(credits);

            em.persist(course);

            tx.commit();
            System.out.println("Course Created Successfully!");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }

    public void assignFaculty(Long courseId, Long facultyId) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Course course = em.find(Course.class, courseId);
            Faculty faculty = em.find(Faculty.class, facultyId);

            course.setFaculty(faculty);

            tx.commit();
            System.out.println("Faculty Assigned to Course!");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}