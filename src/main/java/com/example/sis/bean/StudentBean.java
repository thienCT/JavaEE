package com.example.sis.bean;


import com.example.sis.entity.Student;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

    @Named
    @RequestScoped
    public class StudentBean {
        @PersistenceContext
        private EntityManager em;

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

        @Transactional
        public String saveStudent() {
            Student student = new Student();
            student.setStudentId(studentId);
            student.setName(name);
            student.setAddress(address);

            em.persist(student);
            return "success.xhtml"; // Redirect after successful save
        }
    }

