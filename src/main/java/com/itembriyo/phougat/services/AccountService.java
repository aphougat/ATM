/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.services;

import com.itembriyo.phougat.containers.Account;
import com.itembriyo.phougat.containers.Transaction;
import com.itembriyo.phougat.containers.User;

import javax.naming.InsufficientResourcesException;

/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */
public interface AccountService {

    public Account getAccount(User user);

    public Double makeTransaction(Account account, Transaction transaction) throws InsufficientResourcesException;


}
