package org.springMVC.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springMVC.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudDAOImpl implements StudentDAO {
    private SessionFactory sessionFactory;

    //constructor DI
    public StudDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveStudent(Student student) {
        String res = "";
        Session session = this.sessionFactory.openSession();
        //Transaction tx = null;
        try {
            //tx = session.beginTransaction();
            session.persist(student);
            //tx.commit();
            res = "Data Saved Successfully...";
        } catch (Exception e) {
            System.err.println(e.getMessage());
            //tx.rollback();
            res = "Data Not Saved";
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return res;
    }

    @Override
    public Student getStudentById(Integer studentId) {
        Student student = new Student();
        Session session = this.sessionFactory.openSession();
        String studentQuery = "FROM Student s where s.studId = :studentId";
        try {
            Query query = session.createQuery(studentQuery);
            //query.setInteger("studentId", studentId);
            student = (Student) query.uniqueResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        Session session = this.sessionFactory.openSession();
        String studentQuery = "FROM Student";
        try {
            Query query = session.createQuery(studentQuery);
            students = query.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return students;
    }
}