package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DOI",
        "name",
        "doi-asserted-by",
        "award"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Funder {

    @JsonProperty("DOI")
    private String dOI;
    @JsonProperty("name")
    private String name;
    @JsonProperty("doi-asserted-by")
    private String doiAssertedBy;
    @JsonProperty("award")
    private List<Object> award = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Funder{" +
                "dOI='" + dOI + '\'' +
                ", name='" + name + '\'' +
                ", doiAssertedBy='" + doiAssertedBy + '\'' +
                ", award=" + award +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("DOI")
    public String getDOI() {
        return dOI;
    }

    @JsonProperty("DOI")
    public void setDOI(String dOI) {
        this.dOI = dOI;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("doi-asserted-by")
    public String getDoiAssertedBy() {
        return doiAssertedBy;
    }

    @JsonProperty("doi-asserted-by")
    public void setDoiAssertedBy(String doiAssertedBy) {
        this.doiAssertedBy = doiAssertedBy;
    }

    @JsonProperty("award")
    public List<Object> getAward() {
        return award;
    }

    @JsonProperty("award")
    public void setAward(List<Object> award) {
        this.award = award;
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