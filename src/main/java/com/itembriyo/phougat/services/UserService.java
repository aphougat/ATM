/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.services;

import com.itembriyo.phougat.containers.User;
import org.springframework.stereotype.Component;

import javax.naming.directory.InvalidAttributeIdentifierException;


public interface UserService {

    public User login(String userName, String password) throws InvalidAttributeIdentifierException;

    public boolean changePassword(String newPassword, User user);
}
