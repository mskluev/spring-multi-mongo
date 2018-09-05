package com.example.multimongo.repo1;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.multimongo.domain.Product;

public interface ProductRepository extends MongoRepository<Product, Integer> {
}
