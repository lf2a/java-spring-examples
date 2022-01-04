package com.lf2a.springdemo;

public class BaseballCoach implements Coach {

    // definir um tipo privado para a dependencia
    private FortuneService fortuneService;

    // definir um construtor para a injeção de dependencia
    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}








