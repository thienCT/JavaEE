package com.example.sis.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

    public class Subject {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long subjectId;

        private String name;
        private Integer credit;

        // Default constructor
        public Subject() {
        }

        // Constructor with parameters
        public Subject(String name, Integer credit) {
            this.name = name;
            this.credit = credit;
        }

        // Getters and setters
        public Long getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(Long subjectId) {
            this.subjectId = subjectId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getCredit() {
            return credit;
        }

        public void setCredit(Integer credit) {
            this.credit = credit;
        }
    }


