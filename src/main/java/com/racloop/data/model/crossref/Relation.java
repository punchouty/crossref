package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cites"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Relation {

    @JsonProperty("cites")
    private List<Object> cites = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Relation{" +
                "cites=" + cites +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("cites")
    public List<Object> getCites() {
        return cites;
    }

    @JsonProperty("cites")
    public void setCites(List<Object> cites) {
        this.cites = cites;
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