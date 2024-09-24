package org.springMVC.dao;

import org.springMVC.entity.ExecutionAuditCheck;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutionAuditCheckDAO {
    void save(ExecutionAuditCheck audit);
}