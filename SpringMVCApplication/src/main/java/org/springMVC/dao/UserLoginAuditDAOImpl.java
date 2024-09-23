package org.springMVC.dao;

import org.springMVC.entity.UserLoginAudit;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

public class UserLoginAuditDAOImpl implements UserLoginAuditDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(UserLoginAudit audit) {
        entityManager.persist(audit);
    }

    @Override
    public UserLoginAudit findByUserNameAndLoginTime(String userName, LocalDateTime loginTime) {
        String query = "FROM UserLoginAudit WHERE userName = :userName AND loginTime = :loginTime";
        return entityManager.createQuery(query, UserLoginAudit.class)
                .setParameter("userName", userName)
                .setParameter("loginTime", loginTime)
                .getSingleResult();
    }
}