package com.lf2a.aroundhandleexception.aspect;

import com.lf2a.aroundhandleexception.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.lf2a.aroundhandleexception.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing Around: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println(e.getMessage());

            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("======> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.lf2a.aroundhandleexception.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing After Finally: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.lf2a.aroundhandleexception.dao.AccountDAO.findAccounts(..))", throwing = "theExec")
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExec) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing After Throwing: " + method);
        System.out.println("\n====>>> Exception is: " + theExec);
    }

    @AfterReturning(pointcut = "execution(* com.lf2a.aroundhandleexception.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n====>>> Executing After Returning: " + method);
        System.out.println("\n====>>> result is: " + result);

        convertAccountNamesToUpperCase(result);
//        System.out.println("\n====>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            String upperCase = account.getName().toUpperCase();
            account.setName(upperCase);
        }
    }

    @Before("com.lf2a.aroundhandleexception.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("==========>>> Executing @Before Membership advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        Object[] objects = joinPoint.getArgs();

        for (Object arg : objects) {
            System.out.println(arg);

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name: " + account.getName());
                System.out.println("account level: " + account.getLevel());
            }
        }
    }
}
