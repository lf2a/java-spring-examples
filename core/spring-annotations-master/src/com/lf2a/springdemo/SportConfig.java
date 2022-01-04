package com.lf2a.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.lf2a.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean // definindo um bean
    public FortuneService sadFortuneService() {
        // o bean id será "sadFortuneService"
        return new SadFortuneService();
    }

    @Bean // definindo o beand e injetando a dependencia
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

}
