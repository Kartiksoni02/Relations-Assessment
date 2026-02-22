package com.capg.assessment.service;

import javax.persistence.*;
import java.util.*;
import com.capg.assessment.entity.*;

public class ReportService {

    private EntityManager em;

    public ReportService(EntityManager em) {
        this.em = em;
    }

    public void getStudentReport(Long studentId) {

        try {

            List<Enrollment> list = em.createQuery(
                "SELECT e FROM Enrollment e WHERE e.student.id = :sid",
                Enrollment.class)
                .setParameter("sid", studentId)
                .getResultList();

            System.out.println("===== Student Academic Report =====");

            for (Enrollment e : list) {
                System.out.println(
                    "Course: " + e.getCourse().getTitle() +
                    " | Grade: " + e.getGrade());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}