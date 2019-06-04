package com.messiwpy.springbootweb.domain;


import javax.persistence.*;

@Entity
public class User {


    @Id
    private String account;
    private String identity;

    @Column(nullable = false)
    private String password;

    public User(){}

    public User(String identity, String account, String password) {
        this.identity = identity;
        this.account = account;
        this.password = password;
    }


    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
