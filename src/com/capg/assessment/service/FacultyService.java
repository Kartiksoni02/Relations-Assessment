package com.capg.assessment.service;

import javax.persistence.*;
import com.capg.assessment.entity.*;

public class FacultyService {

    private EntityManager em;

    public FacultyService(EntityManager em) {
        this.em = em;
    }

    public void addFaculty(String name, String department) {

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Faculty faculty = new Faculty();
            faculty.setName(name);
            faculty.setDepartment(department);

            em.persist(faculty);

            tx.commit();
            System.out.println("Faculty Added Successfully!");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
}