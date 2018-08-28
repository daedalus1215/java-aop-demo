package com.aop.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.aop.demo.dao.*.*())")
    private void forDaoPackage() {}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before beforeAddAccountAdvice() advice");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n =====> Executing @Before performApiAnalystics() advice");

    }
}
