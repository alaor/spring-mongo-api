package com.dito.controller;


import com.dito.dto.external.TimelineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/timeline")
public class TimelineController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @GetMapping
    public TimelineDto getEndpoint() {
        return restTemplate.getForObject("https://storage.googleapis.com/dito-questions/events.json",
                TimelineDto.class);
    }

}
