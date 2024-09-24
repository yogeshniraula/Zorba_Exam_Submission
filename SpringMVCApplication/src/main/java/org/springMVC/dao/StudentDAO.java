package org.springMVC.dao;

import org.springMVC.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentDAO {

    String saveStudent(Student student);
    Student getStudentById(Integer studId);
    List<Student> getAllStudent();
}
