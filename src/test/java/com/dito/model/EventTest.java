package com.dito.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class EventTest {

    @Test
    public void whenCalledGetEvent_theCorrect() {
        Event event = new Event();
        event.setEvent("buy");
        assertThat(event.getEvent().equals("buy"));
    }

}
