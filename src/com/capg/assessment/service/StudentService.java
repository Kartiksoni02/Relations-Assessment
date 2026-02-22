package com.capg.assessment.service;

import javax.persistence.*;
import com.capg.assessment.entity.*;

public class StudentService {

    private EntityManager em;

    public StudentService(EntityManager em) {
        this.em = em;
    }

    public void registerStudent(String name, String email) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Student student = new Student();
            student.setName(name);
            student.setEmail(email);

            em.persist(student);

            tx.commit();
            System.out.println("Student Registered Successfully!");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}