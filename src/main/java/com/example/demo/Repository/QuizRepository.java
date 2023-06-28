package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Quiz;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String>{

}
