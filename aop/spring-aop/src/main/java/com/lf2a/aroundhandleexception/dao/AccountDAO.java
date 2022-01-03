package com.lf2a.aroundhandleexception.dao;

import com.lf2a.aroundhandleexception.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Errrrrrrrrrrrror");
        }

        List<Account> accountList = new ArrayList<>();

        Account account = new Account("Luiz", "d");
        Account account1 = new Account("Filipy", "f");
        Account account2 = new Account("Ana", "c");
        Account account3 = new Account("Maria", "b");
        Account account4 = new Account("Pedro", "a");

        accountList.add(account);
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        accountList.add(account4);

        return accountList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
