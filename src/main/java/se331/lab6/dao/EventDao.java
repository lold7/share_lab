package se331.lab6.dao;

import org.springframework.data.domain.Page;
import se331.lab6.entity.Event;

public interface EventDao {
    Integer getEventSize();

    Page<Event> getEvents(Integer pageSize, Integer page);

    Event getEvent(Long id);
}
