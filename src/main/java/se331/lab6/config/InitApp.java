package se331.lab6.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.lab6.entity.Event;
import se331.lab6.entity.Organizer;
import se331.lab6.entity.Participant;
import se331.lab6.repository.EventRepository;
import se331.lab6.repository.OrganizerRepository;
import se331.lab6.repository.ParticipantRepository;
import se331.lab6.security.user.Role;
import se331.lab6.security.user.User;
import se331.lab6.security.user.UserRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());
        Event tempEvent;
        Event event1, event2, event3, event4;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petsAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        event1 = tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petsAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        event2 = tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petsAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        event3 = tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petsAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        event4 = tempEvent;

        Participant p1 = participantRepository.save(Participant.builder()
                .name("Anawat Boonmee").telNo("081-111-1111").build());
        Participant p2 = participantRepository.save(Participant.builder()
                .name("Siriporn Chaiwong").telNo("082-222-2222").build());
        Participant p3 = participantRepository.save(Participant.builder()
                .name("Kittipong Saelim").telNo("083-333-3333").build());
        Participant p4 = participantRepository.save(Participant.builder()
                .name("Nattaya Phromma").telNo("084-444-4444").build());
        Participant p5 = participantRepository.save(Participant.builder()
                .name("Thanakrit Wongsa").telNo("085-555-5555").build());

        addToEvent(p1, event1);
        addToEvent(p1, event2);
        addToEvent(p1, event3);

        addToEvent(p2, event2);
        addToEvent(p2, event3);
        addToEvent(p2, event4);

        addToEvent(p3, event1);
        addToEvent(p3, event3);
        addToEvent(p3, event4);

        addToEvent(p4, event1);
        addToEvent(p4, event2);
        addToEvent(p4, event4);

        addToEvent(p5, event1);
        addToEvent(p5, event2);
        addToEvent(p5, event3);
        addToEvent(p5, event4);
        addUser();
    }

    User user1, user2, user3;

    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .build();
        user3 = User.builder()
                .username("disableUser")
                .password(encoder.encode("disableUser"))
                .firstname("disableUser")
                .lastname("disableUser")
                .email("disableUser@user.com")
                .enabled(false)
                .build();

        user1.getRoles().add(Role.ROLE_USER);
        user1.getRoles().add(Role.ROLE_ADMIN);

        user2.getRoles().add(Role.ROLE_USER);
        user3.getRoles().add(Role.ROLE_USER);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    private void addToEvent(Participant participant, Event event) {
        participant.getEventHistories().add(event);
        event.getParticipants().add(participant);
    }
}
