package com.lf2a.afterreturning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.lf2a.afterreturning.aspect.AopExpressions.forDaoPackage()")
    public void logToCloudAsync() {
        System.out.println("==========>>> Logging to cloud in async fashion");
    }
}