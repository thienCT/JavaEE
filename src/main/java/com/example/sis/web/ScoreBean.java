package com.example.sis.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "scoreBean")
@SessionScoped
public class ScoreBean {

    private int studentId;
    private int subjectId;
    private double score1;
    private double score2;
    private double grade;


    public ScoreBean() {
        ScoreBean scoreBean = new ScoreBean();

    }

    public ScoreBean(int studentId, int subjectId, double score1, double score2) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.score1 = score1;
        this.score2 = score2;
        this.grade = calculateGrade(score1, score2);
    }

    // Getter và Setter
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
        this.grade = calculateGrade(score1, this.score2);
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
        this.grade = calculateGrade(this.score1, score2);
    }

    public double getGrade() {
        return grade;
    }


    private double calculateGrade(double score1, double score2) {
        return 0.3 * score1 + 0.7 * score2;
    }

    @Override
    public String toString() {
        return "ScoreBean{studentId=" + studentId + ", subjectId=" + subjectId
                + ", score1=" + score1 + ", score2=" + score2 + ", grade=" + grade + '}';
    }
}

