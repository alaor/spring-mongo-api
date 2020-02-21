package com.dito.controller;

import com.dito.exception.BadRequestException;
import com.dito.model.Event;
import com.dito.repository.EventRepository;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @ApiOperation(value = "Listar todos os eventos.")
    public List<Event> all() {
        return repository.findAll();
    }

    @GetMapping("/autocomplete/{find}")
    @ApiOperation(value = "Listar todos os eventos por nome do evento contendo partes do filtro informado.")
    public List<Event> autocomplete(@PathVariable(value = "find") String find) {
        return repository.findEventsByEvent(find);
    }

    @SneakyThrows
    @PostMapping
    @ApiOperation(value = "Criar um novo evento.")
    public ResponseEntity<Event> create(@Valid @RequestBody Event event) {
        if (event.getEvent() == null)
            throw new BadRequestException("O campo 'event' não pode ser nulo.");
        event.setTimestamp(new Date());
        return ResponseEntity.ok(repository.save(event));
    }
}
