package com.example.sis.service;


import com.example.sis.entity.Score;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

    @Stateless
    public class ScoreService {

        @Inject
        private EntityManager em;

        // Method to add a score
        public void addScore(Score score) {
            em.persist(score);  // Persist the score to the database
        }

        // Method to update a score
        public void updateScore(Score score) {
            em.merge(score);  // Merge changes to an existing score
        }

        // Method to delete a score by its ID
        public void deleteScore(Long scoreId) {
            Score score = em.find(Score.class, scoreId);  // Find the score by its ID
            if (score != null) {
                em.remove(score);  // Remove the score from the database
            }
        }

        // Method to retrieve a score by its ID
        public Score getScoreById(Long scoreId) {
            return em.find(Score.class, scoreId);  // Find the score by its ID
        }

        // Method to calculate and return the grade for a score
        public Character calculateGrade(Float score1, Float score2) {
            float gradeValue = (0.3f * score1) + (0.7f * score2);
            if (gradeValue >= 8.0) return 'A';
            if (gradeValue >= 6.0) return 'B';
            if (gradeValue >= 4.0) return 'D';
            return 'F';
        }
    }


