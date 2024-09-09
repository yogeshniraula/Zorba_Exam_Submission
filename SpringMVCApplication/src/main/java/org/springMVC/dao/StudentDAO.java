package org.springMVC.dao;

import org.springMVC.entity.Student;

import java.util.List;

public interface StudentDAO {

    String saveStudent(Student student);
    Student getStudentById(Integer studId);
    List<Student> getAllStudent();
}
