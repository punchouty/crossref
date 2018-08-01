package com.racloop.data.repositories.elasticsearch;

import com.racloop.data.model.es.Reference;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticSearchReferenceRepository extends ElasticsearchRepository<Reference, String> {
}
