package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Model.user;

public interface userRepository extends MongoRepository<user, String> {

    boolean existsByname(String name);

    boolean existsByemail(String email);

    List<user> findByemail(String email);
      
}

