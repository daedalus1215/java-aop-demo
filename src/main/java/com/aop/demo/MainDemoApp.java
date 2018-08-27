package com.aop.demo;

import com.aop.demo.Entity.AccountEntity;
import com.aop.demo.dao.AccountDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {
        // read spring config java class
        ApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);



        // get the bean from the spring container
        AccountDAO theAccountDAO = (AccountDAO) context.getBean("accountDAO", AccountDAO.class);


        System.out.println("return: " + theAccountDAO.returnAccountOne());

        // call the business method
        theAccountDAO.addAccount();

        theAccountDAO.addAccountEntity(new AccountEntity("Thomas", "12"), false);
        // close the context
//        context.cl
    }
}
