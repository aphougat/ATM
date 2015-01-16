/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.accessor.impl;

import com.itembriyo.phougat.accessor.XyzBankAccessor;
import com.itembriyo.phougat.containers.*;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */
@Component(value = "bankAccessor")
public class XyzBankAccessorImpl implements XyzBankAccessor {

    static List<Account> accounts = new ArrayList<Account>();
    static List<User> users = new ArrayList<User>();

    public void loadData()
    {
        try {
            Class[] classes = new Class[2];
            classes[0] = AccountList.class;
            classes[1] = Account.class;
            JAXBContext jc = JAXBContext.newInstance(classes);
            Unmarshaller u = jc.createUnmarshaller();


            //T format = (T) u.unmarshal(formatFile);
            AccountList doc=  (AccountList)u.unmarshal(XyzBankAccessorImpl.class.getResourceAsStream("/SampleAccounts.xml"));

            accounts.addAll(doc.getAccount());
            JAXBContext jc1 = JAXBContext.newInstance(UserList.class);
            Unmarshaller u1 = jc1.createUnmarshaller();
            UserList userDoc= (UserList) u1.unmarshal(XyzBankAccessorImpl.class.getResourceAsStream("/SampleUsers.xml"));
            users.addAll(userDoc.getUser());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Account getAccount(User user) {
        for(Account account : accounts)
        {
            if(account.getUser().equals(user))
            {
                return account;
            }
        }
        return null;
    }

    @Override
    public Double makeTransaction(Account account, Transaction transaction) {
        return null;
    }

    @Override
    public User login(String userName, String password) {

        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        if(users.contains(user) )
        {
            return users.get(users.indexOf(user));
        }
        else
            return null;

    }

    @Override
    public boolean changePassword(String oldPassword) {
        return false;
    }
}
