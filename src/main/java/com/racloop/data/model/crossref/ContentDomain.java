package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "domain",
        "crossmark-restriction"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentDomain {

    @JsonProperty("domain")
    private List<Object> domain = null;
    @JsonProperty("crossmark-restriction")
    private Boolean crossmarkRestriction;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "ContentDomain{" +
                "domain=" + domain +
                ", crossmarkRestriction=" + crossmarkRestriction +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("domain")
    public List<Object> getDomain() {
        return domain;
    }

    @JsonProperty("domain")
    public void setDomain(List<Object> domain) {
        this.domain = domain;
    }

    @JsonProperty("crossmark-restriction")
    public Boolean getCrossmarkRestriction() {
        return crossmarkRestriction;
    }

    @JsonProperty("crossmark-restriction")
    public void setCrossmarkRestriction(Boolean crossmarkRestriction) {
        this.crossmarkRestriction = crossmarkRestriction;
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