package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Model.product;

public interface ProductRepository extends MongoRepository<product, String> {

    
}
