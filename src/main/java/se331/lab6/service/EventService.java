package se331.lab6.service;

import se331.lab6.entity.Event;

import java.util.List;

public interface EventService {
    Integer getEventSize();

    List<Event> getEvents(Integer pageSize, Integer page);

    Event getEvent(Long id);
}
