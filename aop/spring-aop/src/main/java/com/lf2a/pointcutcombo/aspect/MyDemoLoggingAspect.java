package com.lf2a.pointcutcombo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.lf2a.pointcutcombo.dao.*.*(..))")
    // vai executar todos os metodos de todas as classes do pacote "com.lf2a.aopdemo.dao" e que tenham quaisquer modificadores de acesso
    // e que possuem quaisquer parametros
    private void forDaoPackage() {
    }

    @Pointcut("execution(* com.lf2a.pointcutcombo.dao.*.get*(..))")
    private void getter() {
    }

    @Pointcut("execution(* com.lf2a.pointcutcombo.dao.*.set*(..))")
    private void setter() {
    }

    // incluindo forDaoPackage() e excluindo getter() e setter()
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("==========>>> Executing @Before Membership advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("==========>>> Performing API Analytics");
    }
}
