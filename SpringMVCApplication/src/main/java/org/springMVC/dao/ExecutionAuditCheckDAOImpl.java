package org.springMVC.dao;

import org.springMVC.entity.ExecutionAuditCheck;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class ExecutionAuditCheckDAOImpl  implements ExecutionAuditCheckDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(ExecutionAuditCheck audit) {
        entityManager.persist(audit);
    }

}