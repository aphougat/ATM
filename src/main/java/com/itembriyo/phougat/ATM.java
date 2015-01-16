/*
 * Copyright (c) 2015. Abhay Phougat. All Rights Reserved.
 */

package com.itembriyo.phougat;

import com.itembriyo.phougat.accessor.impl.XyzBankAccessorImpl;
import com.itembriyo.phougat.containers.*;
import com.itembriyo.phougat.facade.impl.UserFacade;
import com.itembriyo.phougat.facade.impl.UserFacadeImpl;
import com.itembriyo.phougat.services.AccountService;
import com.itembriyo.phougat.services.EncriptionService;
import com.itembriyo.phougat.services.impl.AccountServiceImpl;
import com.itembriyo.phougat.services.impl.Md5EncriptionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.InsufficientResourcesException;
import javax.naming.directory.InvalidAttributeIdentifierException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.*;


public class ATM {

private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        XyzBankAccessorImpl bankAccessor = context.getBean(XyzBankAccessorImpl.class);
        bankAccessor.loadData();
      /*  ATM atm = new ATM();
        System.exit(atm.generateSampleData(context));*/
        String response;
       System.out.println("Please put your card details ");
        System.out.println("User Name : ");
        response = input.next();
        System.out.println("Password : ");
        String pass = input.next();
        UserFacade userFacade = context.getBean(UserFacadeImpl.class);
        AccountService accountService = context.getBean(AccountServiceImpl.class);

        try {
            Account account = userFacade.getDetails(response,pass);

            makeTransaction(accountService, account);

        } catch (InvalidAttributeIdentifierException e) {
            System.out.println("Invalid Credentails , Please try Again");

            main(new String[0]);
        } catch (InsufficientResourcesException e) {
            System.out.println("Insufficient funds in your account, Please try Again");

            main(new String[0]);
        }


    }

    private static void makeTransaction(AccountService accountService, Account account) throws InsufficientResourcesException {
        String response;
        System.out.println("Welcome : "+account.getUser().getName());

        System.out.println("Balance : "+account.getBalance());

        System.out.println("Make Transaction : "+ TransactionType.values()[0] +" OR "+ TransactionType.values()[1] );

        String transactionType = input.next();
        String actualTransaction = "incorrect";
        for(TransactionType type : TransactionType.values())
        {
            if(transactionType.equalsIgnoreCase(type.toString()))
            {
                actualTransaction = type.toString();
                break;
            }
        }

        if(!actualTransaction.equalsIgnoreCase("incorrect"))
        {
            System.out.println("Enter Amount : " );
            Double amount = input.nextDouble();
            Transaction transaction = new Transaction(amount,account,new Date(),TransactionType.valueOf(actualTransaction));

            Double newAmount = accountService.makeTransaction(account,transaction);

            System.out.println("Transaction was successfull new Amount is: "+ newAmount );

            System.out.println("Would you like to continue , logout , any other inputs to close the program");

            response = input.next();

            if(response.equalsIgnoreCase("continue"))
            {
                makeTransaction(accountService,account);
            }
            else if(response.equalsIgnoreCase("logout"))
            {
                account= null;
                main(new String[0]);
            }
            else {
                System.exit(0);
            }
        }
    }

   /* public int generateSampleData(ApplicationContext context)
    {
        EncriptionService encriptionService = context.getBean(Md5EncriptionService.class);
        UserList userList = new UserList();
        List<User> users = new ArrayList<User>();
        AccountList accountList = new AccountList();
        List<Account> accounts = new ArrayList<Account>();
        for(int i=0;i< 35; i++)
        {
            User user  = new User();
            user.setName("abhay");
            user.setUsername("abhay"+i);
            user.setPassword(encriptionService.encriptPassword("12345"));
            user.setDob(new Date());
            users.add(user);
            Account account;
            if(i%2 > 0) {
                account = new Account(user, 1000 + i, "10010110" + i, AccountType.CURRENT, new Date());
            }else
            {
                account = new Account(user, 1000 + i, "10010110" + i, AccountType.SAVINGS, new Date());
            }
            accounts.add(account);

        }
        accountList.setAccount(accounts);
        userList.setUser(users);
        try {


            JAXBContext jaxbContext = JAXBContext.newInstance(AccountList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            jaxbMarshaller.marshal(accountList, System.out);

            JAXBContext jaxbContext1 = JAXBContext.newInstance(UserList.class);
            Marshaller jaxbMarshaller1 = jaxbContext1.createMarshaller();

            // output pretty printed
            jaxbMarshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            jaxbMarshaller1.marshal(userList, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
            return 1;
        }

        return 0;
    }*/
}
