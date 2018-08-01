package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "start-index",
        "search-terms"
})
public class Query {

    @JsonProperty("start-index")
    private Integer startIndex;
    @JsonProperty("search-terms")
    private String searchTerms;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Query{" +
                "startIndex=" + startIndex +
                ", searchTerms='" + searchTerms + '\'' +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("start-index")
    public Integer getStartIndex() {
        return startIndex;
    }

    @JsonProperty("start-index")
    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    @JsonProperty("search-terms")
    public String getSearchTerms() {
        return searchTerms;
    }

    @JsonProperty("search-terms")
    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}