package se331.lab6.service;

import org.springframework.data.domain.Page;
import se331.lab6.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    List<Organizer> getAllOrganizer();

    Page<Organizer> getOrganizer(Integer page, Integer pageSize);

    Organizer getOrganizer(Long id);

    Organizer save(Organizer organizer);
}
