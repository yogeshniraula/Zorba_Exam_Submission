package org.springMVC.dao;

import org.springMVC.entity.UserLoginAudit;
import org.springframework.stereotype.Repository;
import org.springMVC.entity.User;
import org.springMVC.model.UserModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserLoginAuditDAO
    {
        void save(UserLoginAudit audit);
        UserLoginAudit findByUserNameAndLoginTime(String userName, LocalDateTime loginTime);
    }