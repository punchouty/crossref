package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "facets",
        "next-cursor",
        "total-results",
        "items",
        "items-per-page",
        "query"
})
public class SearchMessage {

    @JsonProperty("facets")
    private Facets facets;
    @JsonProperty("next-cursor")
    private String nextCursor;
    @JsonProperty("total-results")
    private Integer totalResults;
    @JsonProperty("items")
    private List<Item> items = null;
    @JsonProperty("items-per-page")
    private Integer itemsPerPage;
    @JsonProperty("query")
    private Query query;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "SearchMessage{" +
                "facets=" + facets +
                ", nextCursor=" + nextCursor +
                ", totalResults=" + totalResults +
                ", items=" + items +
                ", itemsPerPage=" + itemsPerPage +
                ", query=" + query +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("facets")
    public Facets getFacets() {
        return facets;
    }

    @JsonProperty("facets")
    public void setFacets(Facets facets) {
        this.facets = facets;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
    }

    @JsonProperty("total-results")
    public Integer getTotalResults() {
        return totalResults;
    }

    @JsonProperty("total-results")
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonProperty("items-per-page")
    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    @JsonProperty("items-per-page")
    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    @JsonProperty("query")
    public Query getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(Query query) {
        this.query = query;
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
