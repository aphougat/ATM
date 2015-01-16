/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.containers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */

public class Account {


    private AccountType accountType;

    @XmlElement
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    @XmlElement
    public void setUser(User user) {
        this.user = user;
    }
    @XmlElement
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    private User user;                 // account holders client

    private double balance;              // current account balance

    private String account_number;        // account number

    private List<Transaction> transactions;

    public Date getOpeningDate() {
        return openingDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    private Date openingDate;

    /**
     *
     * @return transactions
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     *
     * @param transactions
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     *
     * @return user
     */
    public User getUser() {
        return user;
    }


    public double getBalance()
    {
        return balance;
    }

    @XmlElement
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    @XmlElement
    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public Account(){};

    public Account(User user, double balance, String account_number, AccountType accountType, Date openingDate) {
        this.user = user;
        this.balance = balance;
        this.account_number = account_number;
        this.accountType = accountType;
        this.openingDate = openingDate;
    }
}
