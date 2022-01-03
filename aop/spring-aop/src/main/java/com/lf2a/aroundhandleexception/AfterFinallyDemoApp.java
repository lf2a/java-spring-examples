package com.lf2a.aroundhandleexception;

import com.lf2a.aroundhandleexception.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((DemoConfig.class));

        AccountDAO account = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = null;

        try {
            // add uma flag para simular uma excecao
            boolean tripWire = false;
            accountList = account.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Main program: After Throwing");

        System.out.println(accountList);

        context.close();
    }
}
