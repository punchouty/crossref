package com.racloop.data.service;

import com.racloop.data.model.mongodb.Work;
import com.racloop.data.repositories.elasticsearch.ElasticSearchReferenceRepository;
import com.racloop.data.repositories.mongodb.MongoDbWorkRepository;
import com.racloop.data.service.mongodb.NameHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

@Service
public class DataSynch {

    @Autowired
    private MongoDbWorkRepository mongoDbWorkRepository;

    @Autowired
    private ElasticSearchReferenceRepository elasticSearchWorkRepository;

    @Autowired
    private NameHandler nameHandler;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public void asyncPopulate() {
        int start = 0;
        int count = 93585242;
        int pageSize = 1000;
        int iterations = count/pageSize;
        for (int i = start; i < iterations; i++) {
            PageRequest pageRequest = PageRequest.of(i, pageSize);
            Page<Work> page = mongoDbWorkRepository.findAll(pageRequest);
            for (Work work : page.getContent()) {
//                elasticSearchWorkRepository.save(new Reference(work));
                nameHandler.process(work);
            }
            System.out.println("End Iteration : " + i + ", of " + iterations);
        }
        System.out.println("Processing Complete");
    }
}
