package org.springmvc.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springmvc.entity.User;

import java.util.ArrayList;
import java.util.List;

@Component

public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    //constructor DI
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveUser(User user) {
        String res = "";
        Session session = this.sessionFactory.openSession();
        //Transaction tx = null;
        try {
            //tx = session.beginTransaction();
            session.persist(user);
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
    public User getUserById(Integer userId) {
        User user = new User();
        Session session = this.sessionFactory.openSession();
        String userQuery = "FROM User s where s.userId = :userId";
        try {
            Query query = session.createQuery(userQuery);
            query.setInteger("userId", userId);
            user = (User) query.uniqueResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Session session = this.sessionFactory.openSession();
        String userQuery = "FROM User";
        try {
            Query query = session.createQuery(userQuery);
            users = query.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return users;
    }
}