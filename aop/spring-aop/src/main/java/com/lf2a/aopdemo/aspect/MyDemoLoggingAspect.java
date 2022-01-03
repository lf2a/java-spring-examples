package com.lf2a.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void addAccount())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("==========>>> Executing @Before advice on method");
//    }

//    @Before("execution(public void com.lf2a.aopdemo.dao.MembershipDAO.addAccount())")
//    // vai executar quando MembershipDAO.addAccount() for executado
//    public void beforeAddAccountAdviceMembership() {
//        System.out.println("==========>>> Executing @Before Membership advice on method");
//    }

//    @Before("execution(public void add*())")
//    // vai executar todos os metodos que comecam com "add"
//    public void beforeAddAccountAdvice() {
//        System.out.println("==========>>> Executing @Before Membership advice on method");
//    }

//    @Before("execution(void add*())")
//    // vai executar todos os metodos que comecam com "add" e tenham quaisquer modificadores de acesso
//    public void beforeAddAccountAdvice() {
//        System.out.println("==========>>> Executing @Before Membership advice on method");
//    }

//    @Before("execution(void add*(com.lf2a.aopdemo.Account))")
//    // vai executar todos os metodos que comecam com "add" e tenham quaisquer modificadores de acesso e que possuem
//    // um parametro do tipo Account do pacote "com.lf2a.aopdemo"
//    public void beforeAddAccountAdvice() {
//        System.out.println("==========>>> Executing @Before Membership advice on method");
//    }

//    @Before("execution(* add*(com.lf2a.aopdemo.Account, ..))")
//    // vai executar todos os metodos que comecam com "add" e tenham quaisquer modificadores de acesso e que possuem
//    // um ou mais parametros, em que o primeiro parametro de ser obrigatoriamente do tipo Account
//    public void beforeAddAccountAdvice() {
//        System.out.println("==========>>> Executing @Before Membership advice on method");
//    }

//    @Before("execution(* add*(..))")
//    // vai executar todos os metodos que comecam com "add" e tenham quaisquer modificadores de acesso e que possuem
//    // quaisquer parametros
//    public void beforeAddAccountAdvice() {
//        System.out.println("==========>>> Executing @Before Membership advice on method");
//    }

    @Before("execution(* com.lf2a.aopdemo.dao.*.*(..))")
    // vai executar todos os metodos de todas as classes do pacote "com.lf2a.aopdemo.dao" e que tenham quaisquer modificadores de acesso
    // e que possuem quaisquer parametros
    public void beforeAddAccountAdvice() {
        System.out.println("==========>>> Executing @Before Membership advice on method");
    }
}
