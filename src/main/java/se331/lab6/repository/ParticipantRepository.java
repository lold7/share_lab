package se331.lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab6.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
