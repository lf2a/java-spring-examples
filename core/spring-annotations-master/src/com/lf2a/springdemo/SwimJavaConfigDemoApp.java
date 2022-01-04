package com.lf2a.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        // lendo arquivo de configuração
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // obtendo o bean do container
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        // chamando o metodo do bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(theCoach.getEmail());
        System.out.println(theCoach.getTeam());

        // fechando o contexto
        context.close();
    }
}
