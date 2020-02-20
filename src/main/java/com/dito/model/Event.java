package com.dito.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "events")
public class Event implements Serializable {

    @Id
    private String id;
    private String event;
    private Date timestamp;

}
