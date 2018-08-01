package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "URL",
        "start",
        "delay-in-days",
        "content-version"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class License {

    @JsonProperty("URL")
    private String uRL;
    @JsonProperty("start")
    private Start start;
    @JsonProperty("delay-in-days")
    private Long delayInDays;
    @JsonProperty("content-version")
    private String contentVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "License{" +
                "uRL='" + uRL + '\'' +
                ", start=" + start +
                ", delayInDays=" + delayInDays +
                ", contentVersion='" + contentVersion + '\'' +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("URL")
    public String getURL() {
        return uRL;
    }

    @JsonProperty("URL")
    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    @JsonProperty("start")
    public Start getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(Start start) {
        this.start = start;
    }

    @JsonProperty("delay-in-days")
    public Long getDelayInDays() {
        return delayInDays;
    }

    @JsonProperty("delay-in-days")
    public void setDelayInDays(Long delayInDays) {
        this.delayInDays = delayInDays;
    }

    @JsonProperty("content-version")
    public String getContentVersion() {
        return contentVersion;
    }

    @JsonProperty("content-version")
    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
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