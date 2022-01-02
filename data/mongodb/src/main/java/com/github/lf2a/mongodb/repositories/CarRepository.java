package com.github.lf2a.mongodb.repositories;

import com.github.lf2a.mongodb.models.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Set;

public interface CarRepository extends MongoRepository<Car, String> {
    Set<Car> findCarsByColor(String color);

    @Query("{color: ?0}")
    Set<Car> redCars(String c); // with @Query
}
