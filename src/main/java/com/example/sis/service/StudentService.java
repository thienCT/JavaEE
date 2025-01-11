package com.example.sis.service;

import com.example.sis.entity.Score;
import com.example.sis.entity.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
    public class StudentService {

        @PersistenceContext
        private EntityManager em;

        public void addStudent(Student student) {
            em.persist(student);
        }

        public void addScore(Score score) {
            float grade = calculateGrade(score.getScore1(), score.getScore2());
            score.setGrade(convertGrade(grade));
            em.persist(score);
        }

        private float calculateGrade(float score1, float score2) {
            return 0.3f * score1 + 0.7f * score2;
        }

        private float convertGrade(float grade) {
            if (grade >= 8.0) return 'A';
            if (grade >= 6.0) return 'B';
            if (grade >= 4.0) return 'D';
            return 'F';
        }
    }

