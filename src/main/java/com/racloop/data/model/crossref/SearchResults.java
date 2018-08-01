package com.racloop.data.model.crossref;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "message-type",
        "message-version",
        "message"
})
public class SearchResults {

    @JsonProperty("status")
    private String status;
    @JsonProperty("message-type")
    private String messageType;
    @JsonProperty("message-version")
    private String messageVersion;
    @JsonProperty("message")
    private SearchMessage searchMessage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "SearchResults{" +
                "status='" + status + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageVersion='" + messageVersion + '\'' +
                ", searchMessage=" + searchMessage +
                ", additionalProperties=" + additionalProperties +
                "} \n";
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("message-type")
    public String getMessageType() {
        return messageType;
    }

    @JsonProperty("message-type")
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    @JsonProperty("message-version")
    public String getMessageVersion() {
        return messageVersion;
    }

    @JsonProperty("message-version")
    public void setMessageVersion(String messageVersion) {
        this.messageVersion = messageVersion;
    }

    @JsonProperty("message")
    public SearchMessage getSearchMessage() {
        return searchMessage;
    }

    @JsonProperty("message")
    public void setSearchMessage(SearchMessage searchMessage) {
        this.searchMessage = searchMessage;
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