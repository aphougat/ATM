/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.facade.impl;

import com.itembriyo.phougat.containers.Account;
import javax.naming.directory.InvalidAttributeIdentifierException;

/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */
public interface UserFacade {

    public Account getDetails (String userName, String password) throws InvalidAttributeIdentifierException;
}
