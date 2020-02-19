package com.dito.repository;

import com.dito.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {

    @Query("{event : { $regex: ?0, $options:'i' } }")
    List<Event> findEventsByEvent(String event);

}
