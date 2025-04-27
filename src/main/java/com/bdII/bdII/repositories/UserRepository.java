package com.bdII.bdII.repositories;

import com.bdII.bdII.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}