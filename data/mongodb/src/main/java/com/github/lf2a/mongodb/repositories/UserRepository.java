package com.github.lf2a.mongodb.repositories;

import com.github.lf2a.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
