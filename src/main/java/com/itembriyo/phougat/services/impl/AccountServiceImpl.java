/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.services.impl;

import com.itembriyo.phougat.accessor.XyzBankAccessor;
import com.itembriyo.phougat.containers.Account;
import com.itembriyo.phougat.containers.Transaction;
import com.itembriyo.phougat.containers.TransactionType;
import com.itembriyo.phougat.containers.User;
import com.itembriyo.phougat.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.InsufficientResourcesException;

/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */
@Component
public class AccountServiceImpl implements AccountService {
    @Autowired
    private XyzBankAccessor bankAccessor;
    @Override
    public Account getAccount(User user) {

        return bankAccessor.getAccount(user);

    }

    @Override
    public Double makeTransaction(Account account, Transaction transaction) throws InsufficientResourcesException{

        synchronized(account.getAccount_number())
        {
            if(transaction.getType().equals(TransactionType.DEPOSIT))
            {
                account.setBalance(account.getBalance()+transaction.getAmount());
            }
            if(transaction.getType().equals(TransactionType.WIDRAW) && account.getBalance() < transaction.getAmount())
            {
                throw new InsufficientResourcesException("Insufficient funds");
            }
            else if(transaction.getType().equals(TransactionType.WIDRAW) && account.getBalance() > transaction.getAmount())
            {
                account.setBalance(account.getBalance()-transaction.getAmount());
            }

        }

         return account.getBalance();

    }
}
