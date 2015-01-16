/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.services.impl;

import com.itembriyo.phougat.accessor.XyzBankAccessor;
import com.itembriyo.phougat.containers.User;
import com.itembriyo.phougat.services.EncriptionService;
import com.itembriyo.phougat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.naming.directory.InvalidAttributeIdentifierException;

/**
 * Created by abhay.narain.phougat on 1/15/2015.
 */
@Component(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private EncriptionService encriptionService;
    @Autowired
    private XyzBankAccessor bankAccessor;


    @Override
    public User login(String userName, String password) throws InvalidAttributeIdentifierException {

            User returnedUser =  bankAccessor.login(userName,encriptionService.encriptPassword(password));

        if(returnedUser != null)
        {
            return returnedUser;
        }
        else {
            throw new InvalidAttributeIdentifierException("User not found");
        }
    }

    /**
     *
     * @param newPassword
     * @return
     */
    @Override
    public boolean changePassword(String newPassword, User user) {

        if(user != null) {
            return bankAccessor.changePassword(encriptionService.encriptPassword(newPassword));
        }
        else return false;
    }
}
