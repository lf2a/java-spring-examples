package com.lf2a.pointcut.dao;

import com.lf2a.pointcut.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
        return false;
    }
}
