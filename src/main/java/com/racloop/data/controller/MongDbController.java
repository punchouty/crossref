package com.racloop.data.controller;

import com.mongodb.client.MongoCollection;
import com.racloop.data.model.mongodb.Author;
import com.racloop.data.model.mongodb.Work;
import com.racloop.data.repositories.mongodb.MongoDbWorkRepository;
import com.racloop.data.service.mongodb.NameHandler;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MongDbController {

    @Autowired
    private MongoDbWorkRepository mongoDbWorkRepository;

    @Autowired
    private NameHandler nameHandler;

    @Autowired
    private MongoOperations mongoOperations;

    @RequestMapping("/test3")
    public String test3() {
        Query query = new Query();
        query.limit(10);
        query.addCriteria(Criteria.where("id").is("58d193d30c62134f84666e36"));
        MongoCollection<Document> collection = mongoOperations.getCollection("");//find(query, Work.class);
        //mongoOperations.
        return "success 3";
    }

    @RequestMapping("/test2")
    public List<Work> test2() {
        Query query = new Query();
        query.limit(10);
        query.addCriteria(Criteria.where("id").is("58d193d30c62134f84666e36"));
        List<Work> works = mongoOperations.find(query, Work.class);
        return works;
    }

    @RequestMapping("/test1")
    public Work test1() {
        return mongoDbWorkRepository.findById("58d193d30c62134f84666e36").get();
    }

    @RequestMapping("/test")
    public List<Work> test() {
        List<Work> works = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            PageRequest pageRequest = PageRequest.of(i, 10);
            Page<Work> page = mongoDbWorkRepository.findAll(pageRequest);
            works.addAll(page.getContent());
        }
        return works;
    }

    @RequestMapping("/test/{doi}")
    public Work doi(@PathVariable String doi) {
        Work work = mongoDbWorkRepository.findById(doi).get();
        for (Author author : work.getAuthor()) {
            System.out.println(author.getFamily());
        }
        return work;
    }
}
