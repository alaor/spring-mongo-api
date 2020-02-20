package com.dito.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimelineDto {

    @JsonProperty("events")
    private List<EventsDto> events;

    public List<EventsDto> getEvents() {
        return events;
    }

    public void setEvents(List<EventsDto> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "ResponseApiTimelineDto{" +
                "events=" + events +
                '}';
    }
}
