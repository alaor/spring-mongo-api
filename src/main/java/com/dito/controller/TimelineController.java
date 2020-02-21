package com.dito.controller;

import com.dito.dto.FormatedTimelineDto;
import com.dito.service.TimelineService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timeline")
public class TimelineController {

    @Autowired
    private TimelineService service;

    @GetMapping
    @ApiOperation(value = "Formata os dados da timeline de compras fornecida pela Dito.")
    public ResponseEntity<FormatedTimelineDto> getEndpoint() {
        return ResponseEntity.ok(new FormatedTimelineDto(service.getTimeline()));
    }

}
