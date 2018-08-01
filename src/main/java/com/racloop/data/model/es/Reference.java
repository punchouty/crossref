package com.racloop.data.model.es;


import com.racloop.data.model.mongodb.Work;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.HashSet;

@Document(indexName = "crossref", type = "reference")
public class Reference {

    @Id
    private String id;
    private String doi;
    private String referenceText;
    private HashSet<String> subject = new HashSet<>();

    public Reference() {

    }

    public Reference(Work work) {
        this.id = work.getId();
        this.doi = work.getDoi();
        this.referenceText = work.getReferenceText();
        this.subject = work.getSubject();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getReferenceText() {
        return referenceText;
    }

    public void setReferenceText(String referenceText) {
        this.referenceText = referenceText;
    }
}
