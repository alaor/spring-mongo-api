package com.dito.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventsApiDto {

    private String event;
    private String timestamp;
    private String revenue;
    @JsonProperty("custom_data")
    private List<CustomDataApiDto> customData;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public List<CustomDataApiDto> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomDataApiDto> customData) {
        this.customData = customData;
    }

    @Override
    public String toString() {
        return "EventsApiDto{" +
                "event='" + event + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", revenue='" + revenue + '\'' +
                ", customData=" + customData +
                '}';
    }
}
