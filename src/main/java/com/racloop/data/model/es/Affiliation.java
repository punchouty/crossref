package com.racloop.data.model.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "crossref", type = "affiliation")
public class Affiliation {

    @Id
    private String id;
    private String name;
}
