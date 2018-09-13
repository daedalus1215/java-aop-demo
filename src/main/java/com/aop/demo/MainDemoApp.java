package com.aop.demo;

import com.aop.demo.Entity.AccountEntity;
import com.aop.demo.dao.AccountDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) throws Exception {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);



        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);


        System.out.println("return: " + theAccountDAO.returnAccountOne());


        theAccountDAO.addAccountEntity(new AccountEntity("Thomas", "13"), false);
        theAccountDAO.addAccountEntity(new AccountEntity("Benjamin", "14"), false);
        theAccountDAO.addAccountEntity(new AccountEntity("Hamilton", "15"), false);

        theAccountDAO.setId(1);
        System.out.println(theAccountDAO.getId());

        List<AccountEntity> entities = theAccountDAO.findAccounts();

        for (AccountEntity entity : entities) {
            System.out.println("The Account's level is set at: " + ((AccountEntity) entity).getLevel());
            System.out.println("The Account's name is set at: " + ((AccountEntity) entity).getName());
        }


        // close the context
        context.close();
    }
}
