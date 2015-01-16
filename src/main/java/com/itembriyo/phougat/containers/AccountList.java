/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat.containers;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


/**
 * Created by abhay.narain.phougat on 1/16/2015.
 */
@XmlRootElement
public class AccountList {

    public List<Account> getAccount() {
        return account;
    }

    @XmlElement
    public void setAccount(List<Account> account) {
        this.account = account;
    }

    private List<Account> account;
}
