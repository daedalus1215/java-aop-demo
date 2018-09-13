package com.aop.demo.dao;

import com.aop.demo.Entity.AccountEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private int id;
    private ArrayList<AccountEntity> accountEntities = new ArrayList<AccountEntity>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int returnAccountOne() {
        return 1;
    }

    public void addAccountEntity(AccountEntity entity, boolean vipFlag) {
        this.accountEntities.add(entity);
        System.out.println("adding the account with name:  " + entity.toString());
    }


    public ArrayList<AccountEntity> findAccounts() throws Exception {
        if (this.accountEntities.size() >= 1) {
            return this.accountEntities;
        }

        // simulate a throwing exception
        throw new Exception("Issue with findAccounts()");
    }

}
