package com.aop.demo.dao;

import com.aop.demo.Entity.AccountEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }


    public int returnAccountOne() {
        return 1;
    }

    public void addAccountEntity(AccountEntity entity) {
        System.out.println("adding the account with name:  " + entity.toString());
    }

}
