package com.aop.demo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopPointcutDeclarations {

    @Pointcut("execution(void com.aop.demo.dao.*.*(..))")
    public void forDaoPackage() {}


    // create point cut for getter methods
    @Pointcut("execution(* com.aop.demo.dao.*.get*(..))")
    public void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.aop.demo.dao.*.set*(..))")
    public void setter() {}

    // create point: include package ... exlcude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
