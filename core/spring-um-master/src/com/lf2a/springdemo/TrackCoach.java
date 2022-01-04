package com.lf2a.springdemo;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {
    }

    public TrackCoach(FortuneService theFortuneSerice) {
        fortuneService = theFortuneSerice;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it: " + fortuneService.getFortune();
    }

    // init method: irá ser chamado quando o bean for inicializado
    public void doMyStartupStuff() {
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    // destroy method: irá ser chamado quando o bean for destruido
    public void doMyStartupStuff2() {
        // este método nao ira ser chamado se o escopo for "prototype"
        System.out.println("TrackCoach: inside method doMyStartupStuff2");
    }
}










