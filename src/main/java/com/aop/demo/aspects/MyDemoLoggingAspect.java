package com.aop.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Before("execution(* *(com.aop.demo.Entity.AccountEntity))") // call this aspect's method when addAccount() method is called
    public void beforeAddAccountAdvice() {
        System.out.println("\n========>>>>> Executing @Before advice on addAccount()");
    }
}
