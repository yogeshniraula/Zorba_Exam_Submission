package org.springMVC.dao;

import org.springMVC.entity.ExecutionAuditCheck;
import org.springframework.stereotype.Component;

@Component
public interface ExecutionAuditCheckDAO {
    void save(ExecutionAuditCheck audit);
}