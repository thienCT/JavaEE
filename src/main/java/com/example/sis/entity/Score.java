package com.example.sis.entity;

public class Score {

    private Long scoreId;
    private Long studentId;
    private Long subjectId;
    private Float score1;
    private Float score2;
    private Float grade;

    // Constructor
    public Score(Long scoreId, Long studentId, Long subjectId, Float score1, Float score2, Float grade) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score1 = score1;
        this.score2 = score2;
        this.grade = grade;
    }

    // Getters and Setters
    public Long getScoreId() {
        return scoreId;
    }

    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Float getScore1() {
        return score1;
    }

    public void setScore1(Float score1) {
        this.score1 = score1;
    }

    public Float getScore2() {
        return score2;
    }

    public void setScore2(Float score2) {
        this.score2 = score2;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
}
