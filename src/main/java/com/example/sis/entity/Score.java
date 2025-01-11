package com.example.sis.entity;

    import jakarta.persistence.*;

    @Entity
    public class Score {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "student_id")
        private Student student;

        @ManyToOne
        @JoinColumn(name = "subject_id")
        private Subject subject;

        private float score1;
        private float score2;
        private char grade;


        public char calculateGrade() {
            float finalScore = (0.3f * score1) + (0.7f * score2);
            if (finalScore >= 8.0) return 'A';
            else if (finalScore >= 6.0) return 'B';
            else if (finalScore >= 4.0) return 'D';
            else return 'F';
        }

        // Getters and setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public Student getStudent() { return student; }
        public void setStudent(Student student) { this.student = student; }

        public Subject getSubject() { return subject; }
        public void setSubject(Subject subject) { this.subject = subject; }

        public float getScore1() { return score1; }
        public void setScore1(float score1) { this.score1 = score1; }

        public float getScore2() { return score2; }
        public void setScore2(float score2) { this.score2 = score2; }

        public char getGrade() { return grade; }
        public void setGrade(char grade) { this.grade = grade; }
    }


