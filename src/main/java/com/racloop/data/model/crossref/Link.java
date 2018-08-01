package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "URL",
        "content-type",
        "content-version",
        "intended-application"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {

    @JsonProperty("URL")
    private String uRL;
    @JsonProperty("content-type")
    private String contentType;
    @JsonProperty("content-version")
    private String contentVersion;
    @JsonProperty("intended-application")
    private String intendedApplication;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "Link{" +
                "uRL='" + uRL + '\'' +
                ", contentType='" + contentType + '\'' +
                ", contentVersion='" + contentVersion + '\'' +
                ", intendedApplication='" + intendedApplication + '\'' +
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

    @JsonProperty("content-type")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("content-type")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("content-version")
    public String getContentVersion() {
        return contentVersion;
    }

    @JsonProperty("content-version")
    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    @JsonProperty("intended-application")
    public String getIntendedApplication() {
        return intendedApplication;
    }

    @JsonProperty("intended-application")
    public void setIntendedApplication(String intendedApplication) {
        this.intendedApplication = intendedApplication;
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