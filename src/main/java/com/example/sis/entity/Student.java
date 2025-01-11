package com.example.sis.entity;

    import jakarta.persistence.*;

    @Entity
    public class Student {
        @Id
        private String studentId;

        private String name;
        private String address;

        // Getters and setters
        public String getStudentId() { return studentId; }
        public void setStudentId(String studentId) { this.studentId = studentId; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getAddress() { return address; }
        public void setAddress(String address) { this.address = address; }
    }

