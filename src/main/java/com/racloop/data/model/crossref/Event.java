package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "location",
        "start",
        "end"
})
public class Event {

    @JsonProperty("name")
    private String name;
    @JsonProperty("location")
    private String location;
    @JsonProperty("start")
    private Start start;
    @JsonProperty("end")
    private End end;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("start")
    public Start getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(Start start) {
        this.start = start;
    }

    @JsonProperty("end")
    public End getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(End end) {
        this.end = end;
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