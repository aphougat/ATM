/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.containers;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */
public class Transaction {

    private TransactionType type;

    private static long id = 100001;

    public TransactionType getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }

    public Date getTime() {
        return time;
    }

    private Double amount;

    private Account account;

    private Date time;

    /**
     *
     * @param type
     * @param amount
     * @param account
     */
    public Transaction(Double amount, Account account,Date time, TransactionType type) {
        this.id ++;
        this.amount = amount;
        this.account = account;
        this.time = time;
        this.type = type;
    }

}
