package com.aop.demo.aspects;

import com.aop.demo.Entity.AccountEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {


    @Around(value = "execution(* com.aop.demo.dao.AccountDAO.findAccounts(..))"
    , argNames = "theProceedingJoinPoint")
    public void aroundFindAccounts(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        System.out.print("\n" + MyDemoLoggingAspect.class + "'s afterFindAccountsThrowsException has been triggered - START\n");

        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception exc) {
            System.out.println("\n " + exc.getMessage());
            result = "Nothing exciting here. Move along!";
            throw exc;
        }


        System.out.print("\n" + MyDemoLoggingAspect.class + "'s afterFindAccountsThrowsException has been triggered - END\n");

    }

}
