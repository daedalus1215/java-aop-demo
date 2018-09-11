package com.aop.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyCloudLogAsyncAspect {

    @Before("com.aop.demo.aspects.AopPointcutDeclarations.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n=======> Logging to Cloud in async fashion");
    }
}
