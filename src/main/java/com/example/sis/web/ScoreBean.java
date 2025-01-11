package com.example.sis.web;

import com.example.sis.entity.Score;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ScoreBean {

    // Inject the DataSource using JNDI
    @Resource(lookup = "jdbc/MySQLDataSource")
    private DataSource dataSource;

    // Method to add a score for a student in a subject
    public void addScore(Long studentId, Long subjectId, Float score1, Float score2) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO scores (student_id, subject_id, score1, score2) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setLong(1, studentId);
                stmt.setLong(2, subjectId);
                stmt.setFloat(3, score1);
                stmt.setFloat(4, score2);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    // Method to get all scores for a specific student
    public List<Score> getScoresByStudent(Long studentId) {
        List<Score> scores = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM scores WHERE student_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setLong(1, studentId);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Long scoreId = rs.getLong("score_id");
                        Long subjectId = rs.getLong("subject_id");
                        Float score1 = rs.getFloat("score1");
                        Float score2 = rs.getFloat("score2");
                        Float grade = calculateGrade(score1, score2);
                        scores.add(new Score(scoreId, studentId, subjectId, score1, score2, grade));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return scores;
    }

    // Method to get a score by score ID
    public Score getScoreById(Long scoreId) {
        Score score = null;
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM scores WHERE score_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setLong(1, scoreId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Long studentId = rs.getLong("student_id");
                        Long subjectId = rs.getLong("subject_id");
                        Float score1 = rs.getFloat("score1");
                        Float score2 = rs.getFloat("score2");
                        Float grade = calculateGrade(score1, score2);
                        score = new Score(scoreId, studentId, subjectId, score1, score2, grade);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return score;
    }

    // Method to update a student's score
    public void updateScore(Long scoreId, Float score1, Float score2) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "UPDATE scores SET score1 = ?, score2 = ? WHERE score_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setFloat(1, score1);
                stmt.setFloat(2, score2);
                stmt.setLong(3, scoreId);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    // Method to delete a score by score ID
    public void deleteScore(Long scoreId) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "DELETE FROM scores WHERE score_id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setLong(1, scoreId);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    // Method to calculate the grade based on the formula
    private Float calculateGrade(Float score1, Float score2) {
        if (score1 == null || score2 == null) {
            return null;
        }
        return (0.3f * score1) + (0.7f * score2);
    }
}
