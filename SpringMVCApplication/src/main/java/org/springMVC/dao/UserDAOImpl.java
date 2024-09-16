package org.springMVC.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springMVC.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springMVC.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;
    @PersistenceContext
    private EntityManager entityManager;

    //constructor DI
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String saveUser(UserModel user) {
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

    @Override
    public Optional<Object> findByUsernameAndPassword(String email, String password, String role) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User WHERE email = :username AND password = :password AND role = :vendor");
        query.setParameter("email", email);
        query.setParameter("password", password);
        query.setParameter("role", role);
        return (Optional<Object>) query.uniqueResult();
    }

    @Override
    @Transactional
    public void deleteUserById(Integer userId){

        User user = entityManager.find(User.class, userId);

        // If user exists, delete it
        if (user != null) {
            entityManager.remove(user);
        }


    }

    @Override
    public Optional<Object> findByRole(String role){
        // Create a query to fetch users by role
        String hql = "FROM User WHERE role = :role";
        TypedQuery<User> query = entityManager.createQuery(hql, User.class);
        query.setParameter("role", role);

        // Return the list of users
        return Optional.ofNullable(query.getResultList());
    };

}