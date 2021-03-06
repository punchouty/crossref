package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date-parts"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Issued {

    @JsonProperty("date-parts")
    private List<List<Integer>> dateParts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Issued{" +
                "dateParts=" + dateParts +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("date-parts")
    public List<List<Integer>> getDateParts() {
        return dateParts;
    }

    @JsonProperty("date-parts")
    public void setDateParts(List<List<Integer>> dateParts) {
        this.dateParts = dateParts;
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