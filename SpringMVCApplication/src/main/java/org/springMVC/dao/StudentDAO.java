package org.springMVC.dao;

import org.springMVC.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentDAO {

    String saveStudent(Student student);
    Student getStudentById(Integer studId);
    List<Student> getAllStudent();
}
