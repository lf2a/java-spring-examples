package com.lf2a.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {

        // carrega o arquivo de configuração spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // recebe o bean do spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // chama o método do bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        // fecha o contexto
        context.close();
    }

}







