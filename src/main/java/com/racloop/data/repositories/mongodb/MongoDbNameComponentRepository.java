package com.racloop.data.repositories.mongodb;

import com.racloop.data.model.name.NameComponent;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoDbNameComponentRepository extends MongoRepository<NameComponent, String> {

    public List<NameComponent> findByWord(String word);
    public List<NameComponent> findByWordLowerCase(String wordLowerCase);
}
