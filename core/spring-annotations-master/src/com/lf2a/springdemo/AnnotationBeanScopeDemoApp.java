package com.lf2a.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        Coach alphaCoach = context.getBean("thatSillyCoach", Coach.class);

        boolean result = (theCoach == alphaCoach);
        System.out.println(result);

        System.out.println(theCoach);
        System.out.println(alphaCoach);

        context.close();
    }
}
