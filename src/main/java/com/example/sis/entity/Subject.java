package com.example.sis.entity;

    import jakarta.persistence.*;

    @Entity
    public class Subject {
        @Id
        private String subjectId;

        private String name;
        private int credit;

        // Getters and setters
        public String getSubjectId() { return subjectId; }
        public void setSubjectId(String subjectId) { this.subjectId = subjectId; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getCredit() { return credit; }
        public void setCredit(int credit) { this.credit = credit; }
    }


