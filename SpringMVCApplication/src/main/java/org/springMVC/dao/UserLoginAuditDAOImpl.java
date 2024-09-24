package org.springMVC.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springMVC.entity.UserLoginAudit;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.time.LocalDateTime;


public class UserLoginAuditDAOImpl implements UserLoginAuditDAO {

//    @Autowired
//    UserLoginAudit userLoginAudit;

    private SessionFactory sessionFactory;

    @Autowired
    public UserLoginAuditDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public void save(UserLoginAudit audit) {

        getSession().save(audit);  // Use Hibernate's Session API to save the audit object
    }

    @Override
    @Transactional
    public UserLoginAudit findByUserNameAndLoginTime(String userName, LocalDateTime loginTime) {
        UserLoginAudit audit = new UserLoginAudit();
        String hql = "FROM UserLoginAudit WHERE userName = :userName AND loginTime = :loginTime";
        Query<UserLoginAudit> query = getSession().createQuery(hql, UserLoginAudit.class);
        query.setParameter("userName", userName);
        query.setParameter("loginTime", loginTime);

        return query.uniqueResult();  // Retrieve the single result
    }
}