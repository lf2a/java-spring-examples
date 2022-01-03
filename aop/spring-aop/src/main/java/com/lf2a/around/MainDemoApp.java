package com.lf2a.around;

import com.lf2a.around.dao.AccountDAO;
import com.lf2a.around.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((DemoConfig.class));

        AccountDAO account = context.getBean("accountDAO", AccountDAO.class);
        Account account1 = new Account();
        account1.setName("Luiz");
        account1.setLevel("b");
        account.addAccount(account1, false);

        System.out.println("");

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addSillyMember();

        context.close();
    }
}
