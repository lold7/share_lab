package se331.lab6.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.lab6.entity.Event;
import se331.lab6.entity.EventDTO;
import se331.lab6.entity.Organizer;
import se331.lab6.entity.OrganizerAuthDTO;
import se331.lab6.entity.OrganizerDTO;
import se331.lab6.entity.Participant;
import se331.lab6.entity.ParticipantDetailDTO;

import java.util.List;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    EventDTO getEventDto(Event event);

    List<EventDTO> getEventDto(List<Event> events);

    OrganizerDTO getOrganizerDTO(Organizer organizer);

    List<OrganizerDTO> getOrganizerDTO(List<Organizer> organizers);

    @Mapping(target = "roles", source = "user.roles")
    OrganizerAuthDTO getOrganizerAuthDTO(Organizer organizer);

    ParticipantDetailDTO getParticipantDetailDTO(Participant participant);

    List<ParticipantDetailDTO> getParticipantDetailDTO(List<Participant> participants);
}
