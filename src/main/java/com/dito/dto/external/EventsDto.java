package com.dito.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventsDto {

    private String event;
    private Date timestamp;
    private String revenue;
    @JsonProperty("custom_data")
    private List<CustomDataDto> customData;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public List<CustomDataDto> getCustomData() {
        return customData;
    }

    public void setCustomData(List<CustomDataDto> customData) {
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
