package com.lf2a.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // lendo arquivo de configuração
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // obtendo o bean do container
        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);

        // chamando o metodo do bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // fechando o contexto
        context.close();
    }
}
