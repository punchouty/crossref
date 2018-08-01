package com.racloop.data.repositories.mongodb;

import com.racloop.data.model.mongodb.Work;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoDbWorkRepository extends MongoRepository<Work, String> {

    public List<Work> findByDoi(String doi);
}
