package com.dito.dto.external;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDto {

    private String event;
    private Date timestamp;
    private String revenue;
    @JsonProperty("custom_data")
    private List<CustomDataDto> customData;

}
