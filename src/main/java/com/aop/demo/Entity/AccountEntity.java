package com.aop.demo.Entity;

public class AccountEntity {
    private String name;
    private String level;

    public AccountEntity(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return "AccountEntity{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
