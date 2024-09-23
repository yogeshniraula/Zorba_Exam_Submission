package org.springMVC.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springMVC.dao.ExecutionAuditCheckDAO;
import org.springMVC.entity.ExecutionAuditCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAuditAspect {

    @Autowired
    private ExecutionAuditCheckDAO executionAuditCheckDAO;

    @Around("execution(* com.example.controller.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;

        // Store the audit
        ExecutionAuditCheck audit = new ExecutionAuditCheck();
        audit.setNameOfController(joinPoint.getSignature().getDeclaringTypeName());
        audit.setNameOfMethod(joinPoint.getSignature().getName());
        audit.setExecutionTime(executionTime);

        executionAuditCheckDAO.save(audit);

        return proceed;
    }
}
