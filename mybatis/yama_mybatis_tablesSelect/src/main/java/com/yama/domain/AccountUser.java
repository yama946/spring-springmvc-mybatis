package com.yama.domain;

public class AccountUser extends Account {
    private String username;
    private String address;

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}'+"          "+super.toString();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
