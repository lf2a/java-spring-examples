package com.lf2a.afterreturning.aspect;

import com.lf2a.afterreturning.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(pointcut = "execution(* com.lf2a.afterreturning.dao.AccountDAO.findAccounts(..))", returning = "result")
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

    @Before("com.lf2a.afterreturning.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
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
