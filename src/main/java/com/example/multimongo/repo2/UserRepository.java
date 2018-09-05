package com.example.multimongo.repo2;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.multimongo.domain.User;

public interface UserRepository extends MongoRepository<User, Integer> {
}
