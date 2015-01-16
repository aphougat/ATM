/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.services.impl;

import com.itembriyo.phougat.services.EncriptionService;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.Charset;

/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */
@Component (value="encriptionService")
public class Md5EncriptionService implements EncriptionService {
    /**
     * @param password
     * @return
     */
    @Override
    public String encriptPassword(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes(Charset.forName("UTF-8")));


    }


}
