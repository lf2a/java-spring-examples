package com.lf2a.pointcut.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.lf2a.pointcut.dao.*.*(..))")
    // vai executar todos os metodos de todas as classes do pacote "com.lf2a.aopdemo.dao" e que tenham quaisquer modificadores de acesso
    // e que possuem quaisquer parametros
    private void forDaoPackage() {
    }


    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("==========>>> Executing @Before Membership advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("==========>>> Performing API Analytics");
    }
}
