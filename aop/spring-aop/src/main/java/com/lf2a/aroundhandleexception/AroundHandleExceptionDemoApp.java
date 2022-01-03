package com.lf2a.aroundhandleexception;

import com.lf2a.aroundhandleexception.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AroundHandleExceptionDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext((DemoConfig.class));

        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);
        System.out.println(data);

        context.close();
    }
}
