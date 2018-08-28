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


    // create point cut for getter methods
    @Pointcut("execution(* com.aop.demo.dao.*.get*())")
    private void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.aop.demo.dao.set*(..))")
    private void setter() {}

    // create point: include package ... exlcude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}



    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before beforeAddAccountAdvice() advice");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n =====> Executing @Before performApiAnalystics() advice");

    }
}
