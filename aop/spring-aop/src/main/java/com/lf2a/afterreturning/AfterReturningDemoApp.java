package com.lf2a.afterreturning;

import com.lf2a.afterreturning.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((DemoConfig.class));

        AccountDAO account = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = account.findAccounts();

        System.out.println("Main program: After Returning");

        System.out.println(accountList);

        context.close();
    }
}
