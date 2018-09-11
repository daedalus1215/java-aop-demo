package com.aop.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.aop.demo.aspects.AopPointcutDeclarations.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        Object[] args = theJoinPoint.getArgs();


        System.out.println("\n =====> Executing @Before beforeAddAccountAdvice() advice. " +
                "From: " + theJoinPoint.getSignature() + " with arguments: ");

        for (Object tempArg: args) {
            System.out.println(tempArg.toString());
        }
    }
}
