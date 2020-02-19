package com.dito.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseApiTimelineDto {

    @JsonProperty("events")
    private List<EventsApiDto> events;

    public List<EventsApiDto> getEvents() {
        return events;
    }

    public void setEvents(List<EventsApiDto> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "ResponseApiTimelineDto{" +
                "events=" + events +
                '}';
    }
}
