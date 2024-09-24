package org.springMVC.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springMVC.entity.ExecutionAuditCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.springframework.orm.hibernate3.SessionFactoryUtils.getSession;


@Repository
public class ExecutionAuditCheckDAOImpl  implements ExecutionAuditCheckDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public ExecutionAuditCheckDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public void save(ExecutionAuditCheck audit) {
        getSession().save(audit);
    }

}