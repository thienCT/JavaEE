package com.example.sis.web;

import com.example.sis.entity.Student;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class StudentBean {

    // Inject the DataSource using JNDI
    @Resource(lookup = "jdbc/MySQLDataSource")
    private DataSource dataSource;

    // Method to add a student to the database
    public void addStudent(String name, String address) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO students (name, address) VALUES (?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, address);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    // Method to get a list of all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM students";
            try (PreparedStatement stmt = connection.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Long id = rs.getLong("id");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    students.add(new Student(id, name, address));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return students;
    }

    // Method to get a student by ID
    public Student getStudentById(Long id) {
        Student student = null;
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM students WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setLong(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String name = rs.getString("name");
                        String address = rs.getString("address");
                        student = new Student(id, name, address);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return student;
    }

    // Method to update a student's details
    public void updateStudent(Long id, String name, String address) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "UPDATE students SET name = ?, address = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, name);
                stmt.setString(2, address);
                stmt.setLong(3, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    // Method to delete a student from the database
    public void deleteStudent(Long id) {
        try (Connection connection = dataSource.getConnection()) {
            String query = "DELETE FROM students WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setLong(1, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }
}
