package com.lf2a.pointcut;

import com.lf2a.pointcut.dao.AccountDAO;
import com.lf2a.pointcut.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((DemoConfig.class));

        AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
        account.addAccount(new Account(), false);
        System.out.println("");
        account.doWork();

        System.out.println("");

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addSillyMember();
        System.out.println("");
        membershipDAO.goSleep();

        context.close();
    }
}
