package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "suffix",
        "given",
        "family",
        "affiliation"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {

    @JsonProperty("name")
    private String name;
    @JsonProperty("suffix")
    private String suffix;
    @JsonProperty("given")
    private String given;
    @JsonProperty("family")
    private String family;
    @JsonProperty("affiliation")
    private List<Affiliation> affiliation = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", suffix='" + suffix + '\'' +
                ", given='" + given + '\'' +
                ", family='" + family + '\'' +
                ", affiliation=" + affiliation +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("suffix")
    public String getSuffix() {
        return suffix;
    }

    @JsonProperty("suffix")
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @JsonProperty("given")
    public String getGiven() {
        return given;
    }

    @JsonProperty("given")
    public void setGiven(String given) {
        this.given = given;
    }

    @JsonProperty("family")
    public String getFamily() {
        return family;
    }

    @JsonProperty("family")
    public void setFamily(String family) {
        this.family = family;
    }

    @JsonProperty("affiliation")
    public List<Affiliation> getAffiliation() {
        return affiliation;
    }

    @JsonProperty("affiliation")
    public void setAffiliation(List<Affiliation> affiliation) {
        this.affiliation = affiliation;
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