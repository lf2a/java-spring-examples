package com.lf2a.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("thatSillyCoach") // registrando o bean com o id "thatSillyCoach"
// se o id nao for fornecido, o id do bean será o nome da classe com a primeira letra minuscula, ou seja, "tennisCoach"
//@Scope("prototype") escopo do beans, por padrão é singleton
public class TennisCoach implements Coach {

    @Autowired // field injection
    @Qualifier("randomFortuneService") // deve ser usado quando temos varios beans
    private FortuneService fortuneService;

    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    /* constructor injetion
    @Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    */

    /* // setter injection
    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside setFortuneService() method");
        this.fortuneService = fortuneService;
    }
    */

    /* // method injection
    @Autowired
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }
    */

    @PostConstruct
    // java 11: https://search.maven.org/remotecontent?filepath=javax/annotation/javax.annotation-api/1.3.2/javax.annotation-api-1.3.2.jar
    public void doMyStartupStuff() {
        // init method: irá ser executado depois do contrutor e depois da injeção de dependências
        System.out.println(">> TennisCoach: inside doMyStartupStuff()");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        // irá ser executado antes do bean ser destruido
        // quando o escopo é prototype este metodo não é chamado
        System.out.println(">> TennisCoach: inside doMyCleanupStuff()");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
