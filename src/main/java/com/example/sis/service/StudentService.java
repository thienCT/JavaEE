package com.example.sis.service;

import com.example.sis.entity.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
    public class StudentService {
        @PersistenceContext
        private EntityManager em;

        public void addStudent(Student student) {
            em.persist(student);
        }

        public List<Student> getAllStudents() {
            return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        }
    }


