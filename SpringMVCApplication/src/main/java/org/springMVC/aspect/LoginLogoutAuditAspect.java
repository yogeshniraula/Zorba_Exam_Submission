package org.springMVC.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.SessionFactory;
import org.springMVC.dao.UserLoginAuditDAO;
import org.springMVC.dao.UserLoginAuditDAOImpl;
import org.springMVC.entity.User;
import org.springMVC.entity.UserLoginAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Aspect
@Component
public class LoginLogoutAuditAspect {

//    private User user;

    @Autowired
    private UserLoginAuditDAO userLoginAuditDAO;

    @Autowired
    SessionFactory sessionFactory;


    @Before("execution(* org.springMVC.controller.*.login*(..))")
    public void captureLogin(JoinPoint joinPoint) {
        // Extract user details
        User user = new User();

        String userName = user.getUserName();
        String userType = user.getUserRole();

        UserLoginAudit audit = new UserLoginAudit();
        audit.setUserName(userName);
        audit.setUserType(userType);
        audit.setLoginTime(LocalDateTime.now());

        userLoginAuditDAO.save(audit);
    }

    @After("execution(* org.springMVC.controller.*.logout*(..))")
    public void captureLogout(JoinPoint joinPoint) {
        User user = new User();
        UserLoginAudit userLoginAudit = new UserLoginAudit();
        String userName = user.getUserName();
        LocalDateTime loginTime = userLoginAudit.getLoginTime();

        UserLoginAudit audit = userLoginAuditDAO.findByUserNameAndLoginTime(userName, loginTime);
        if (audit != null) {
            audit.setLogoutTime(LocalDateTime.now());
            userLoginAuditDAO.save(audit);
        }
    }
}
