package com.lf2a.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {
        // carregando arquivo de configuração spring
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // obtendo o bean do container spring
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // chamando métodos do bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getEmailAddress());
        System.out.println(theCoach.getTeam());

        // fechando o contexto
        context.close();
    }
}
