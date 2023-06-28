package com.example.demo.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {
}
