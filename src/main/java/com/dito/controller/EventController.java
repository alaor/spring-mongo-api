package com.dito.controller;

import com.dito.model.Event;
import com.dito.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository repository;

    @GetMapping
    public List<Event> all() {
        return repository.findAll();
    }

    @GetMapping("/autocomplete/{find}")
    public List<Event> autocomplete(@PathVariable(value = "find") String find) {
        return repository.findEventsByEvent(find);
    }

    @PostMapping
    public Event create(@Valid @RequestBody Event event) {
        event.setTimestamp(new Date());
        return repository.save(event);
    }
}
