/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.facade.impl;

import com.itembriyo.phougat.containers.Account;
import com.itembriyo.phougat.containers.User;
import com.itembriyo.phougat.services.AccountService;
import com.itembriyo.phougat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.directory.InvalidAttributeIdentifierException;

/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */
@Component(value="userFacade")
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;
    @Override
    public Account getDetails(String userName, String password) throws InvalidAttributeIdentifierException{


        User user = userService.login(userName,password);

        return accountService.getAccount(user);
    }
}
