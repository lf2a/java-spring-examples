package com.github.lf2a.mongodb;

import com.github.lf2a.mongodb.models.Car;
import com.github.lf2a.mongodb.models.User;
import com.github.lf2a.mongodb.repositories.CarRepository;
import com.github.lf2a.mongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MongodbApplication implements CommandLineRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Car f12 = Car.builder()
                .color("RED")
                .manufacturer("FERRARI")
                .model("F12")
                .build();

        Car ranger = Car.builder()
                .color("RED")
                .manufacturer("FORD")
                .model("RANGER")
                .build();

        // carRepository.saveAll(Arrays.asList(f12, ranger));

        var redCars = carRepository.findCarsByColor("RED");
        System.out.println("red cars: " + redCars);

        var redCars2 = carRepository.redCars("RED");
        System.out.println("red cars 2 : " + redCars2);

        User luiz = User.builder()
                .name("Luiz Filipy")
                .cars(redCars)
                .build();

        // var users = userRepository.save(luiz);
        // System.out.println(users);
    }
}
