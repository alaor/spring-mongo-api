package com.dito.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "events")
public class Event implements Serializable {

    @Id
    @ApiModelProperty(value = "Id.")
    private String id;

    @ApiModelProperty(value = "Descrição do evento.")
    private String event;

    @ApiModelProperty(value = "Data do evento.")
    private Date timestamp;

}
