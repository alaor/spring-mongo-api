package com.dito.controller;

import com.dito.dto.FormatedTimelineDto;
import com.dito.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timeline")
public class TimelineController {

    @Autowired
    private TimelineService service;

    @GetMapping
    public FormatedTimelineDto getEndpoint() {
        return new FormatedTimelineDto(service.getTimeline());
    }

}
