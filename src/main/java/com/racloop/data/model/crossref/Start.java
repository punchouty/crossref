package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date-parts",
        "date-time",
        "timestamp"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Start {

    @JsonProperty("date-parts")
    private List<List<Integer>> dateParts = null;
    @JsonProperty("date-time")
    private String dateTime;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Start{" +
                "dateParts=" + dateParts +
                ", dateTime='" + dateTime + '\'' +
                ", timestamp=" + timestamp +
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

    @JsonProperty("date-time")
    public String getDateTime() {
        return dateTime;
    }

    @JsonProperty("date-time")
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @JsonProperty("timestamp")
    public Long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
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