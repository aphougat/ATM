/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.accessor;

import com.itembriyo.phougat.containers.Account;
import com.itembriyo.phougat.containers.Transaction;
import com.itembriyo.phougat.containers.User;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;

/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */
public interface XyzBankAccessor {
        public Account getAccount(User user);

        public Double makeTransaction(Account account, Transaction transaction);
        public User login(String userName, String password);

        public boolean changePassword(String oldPassword);
}
