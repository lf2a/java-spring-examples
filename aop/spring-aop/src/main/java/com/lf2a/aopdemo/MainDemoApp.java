package com.lf2a.aopdemo;

import com.lf2a.aopdemo.dao.AccountDAO;
import com.lf2a.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((DemoConfig.class));

        AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
        account.addAccount(new Account(), false);
        account.doWork();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addSillyMember();
        membershipDAO.goSleep();

        context.close();
    }
}
