package com.lf2a.aroundhandleexception.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.lf2a.aroundhandleexception.aspect.AopExpressions.forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("==========>>> Performing API Analytics");
    }
}
