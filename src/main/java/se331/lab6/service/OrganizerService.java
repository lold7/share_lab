package se331.lab6.service;

import se331.lab6.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrganizerSize();

    List<Organizer> getOrganizers(Integer pageSize, Integer page);

    Organizer getOrganizer(Long id);

    Organizer save(Organizer organizer);
}
