package com.lf2a.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        // carregando arquivo de configuração spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // obtendo bean do container spring
        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        // checando se são os mesmos beans
        boolean result = theCoach == alphaCoach;
        System.out.println(result);
        System.out.println(theCoach);
        System.out.println(alphaCoach);

        context.close();
    }
}
