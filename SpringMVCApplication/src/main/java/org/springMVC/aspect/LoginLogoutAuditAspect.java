package org.springMVC.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springMVC.dao.UserLoginAuditDAO;
import org.springMVC.entity.User;
import org.springMVC.entity.UserLoginAudit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoginLogoutAuditAspect {

    @Autowired
    private UserLoginAuditDAO userLoginAuditDAO;
    @Autowired
    private UserLoginAudit userLoginAudit;
    @Autowired
    private User user;



    @Before("execution(* org.springMVC.controller.*.login*(..))")
    public void captureLogin(JoinPoint joinPoint) {
        // Extract user details

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
        String userName = user.getUserName();
        LocalDateTime loginTime = userLoginAudit.getLoginTime();

        UserLoginAudit audit = userLoginAuditDAO.findByUserNameAndLoginTime(userName, loginTime);
        if (audit != null) {
            audit.setLogoutTime(LocalDateTime.now());
            userLoginAuditDAO.save(audit);
        }
    }
}
