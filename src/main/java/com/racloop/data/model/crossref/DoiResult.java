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
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoiResult {

    @JsonProperty("status")
    private String status;
    @JsonProperty("message-type")
    private String messageType;
    @JsonProperty("message-version")
    private String messageVersion;
    @JsonProperty("message")
    private Item message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Override
    public String toString() {
        return "DoiResult{" +
                "status='" + status + '\'' +
                ", messageType='" + messageType + '\'' +
                ", messageVersion='" + messageVersion + '\'' +
                ", message=" + message +
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
    public Item getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Item message) {
        this.message = message;
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