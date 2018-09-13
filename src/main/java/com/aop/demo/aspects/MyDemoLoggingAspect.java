package com.aop.demo.aspects;

import com.aop.demo.Entity.AccountEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {

    @Before("com.aop.demo.aspects.AopPointcutDeclarations.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        Object[] args = theJoinPoint.getArgs();


        System.out.println("\n =====> Executing @Before beforeAddAccountAdvice() advice. - START \n" +
                "From: " + theJoinPoint.getSignature() + " with arguments: \n");

        for (Object tempArg: args) {
            if (tempArg instanceof AccountEntity) {
                System.out.println("The Account's level is set at: " + ((AccountEntity) tempArg).getLevel() + "\n");
                System.out.println("The Account's name is set at: " + ((AccountEntity) tempArg).getName() + "\n");
            } else {
                System.out.println(tempArg.toString());
            }
        }

        System.out.println("\n =====> Executing @Before beforeAddAccountAdvice() advice. - END \n");
    }


    @AfterReturning(
            pointcut = "execution(* com.aop.demo.dao.AccountDAO.findAccounts(..))",
            returning="result"
    )
    public void afterFindAccounts(JoinPoint joinPoint, ArrayList<AccountEntity> result) {
        System.out.print("\n" + MyDemoLoggingAspect.class + "'s afterFindAccounts has been triggered - START\n");

        System.out.print("Names are: ");
        for (AccountEntity entity : result) {
            System.out.println("The Account's level is set at: " + ((AccountEntity) entity).getLevel());
            System.out.println("The Account's name is set at: " + ((AccountEntity) entity).getName());
            convertNamesToUpperCase(entity);
        }


        for (AccountEntity entity : result) {
            convertNamesToUpperCase(entity);
        }

        System.out.print(MyDemoLoggingAspect.class + "'s afterFindAccounts has been triggered - END\n");
    }

    private void convertNamesToUpperCase(AccountEntity entity) {
        entity.setName(entity.getName().toUpperCase());
    }





    @AfterThrowing(
            pointcut = "execution(* com.aop.demo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception"
    )
    public void afterFindAccountsThrowsException(Exception exception) {
        System.out.print("\n" + MyDemoLoggingAspect.class + "'s afterFindAccountsThrowsException has been triggered - START\n");
        System.out.println("\n " + exception.getMessage());
        System.out.print("\n" + MyDemoLoggingAspect.class + "'s afterFindAccountsThrowsException has been triggered - END\n");

    }

}
