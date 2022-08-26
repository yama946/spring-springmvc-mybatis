package com.yama.domain;

import java.io.Serializable;

public class Account implements Serializable {
    private  int uid;
    private int id;
    private double money;

//多对一的映射，mabatis中称之为一对一的映射，一个账户只属于一个用户
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "uid=" + uid +
                ", id=" + id +
                ", money=" + money +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
