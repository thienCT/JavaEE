package com.example.sis.service;

import com.example.sis.entity.Score;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
    public class ScoreService {
        @PersistenceContext
        private EntityManager em;

        public void addScore(Score score) {
            score.setGrade(score.calculateGrade());
            em.persist(score);
        }

        public List<Score> getScoresByStudent(String studentId) {
            return em.createQuery("SELECT sc FROM Score sc WHERE sc.student.id = :studentId", Score.class)
                    .setParameter("studentId", studentId)
                    .getResultList();
        }
    }

