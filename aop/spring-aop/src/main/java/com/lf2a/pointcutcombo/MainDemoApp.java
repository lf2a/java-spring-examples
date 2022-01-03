package com.lf2a.pointcutcombo;

import com.lf2a.pointcutcombo.dao.AccountDAO;
import com.lf2a.pointcutcombo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((DemoConfig.class));

        AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
        account.addAccount(new Account(), false);
        System.out.println("");
        account.doWork();

        System.out.println("");

        account.setName("foobar");
        account.setServiceCode("silver");

        String name = account.getName();
        String serviceCode = account.getServiceCode();

        System.out.println("");

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addSillyMember();
        System.out.println("");
        membershipDAO.goSleep();

        context.close();
    }
}
