package se331.lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab6.entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();
}
