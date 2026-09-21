package se331.lab6.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import se331.lab6.dao.ParticipantDao;
import se331.lab6.entity.Participant;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    final ParticipantDao participantDao;

    @Override
    public List<Participant> getAllParticipant() {
        return participantDao.getParticipant(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Participant> getParticipant(Integer page, Integer pageSize) {
        return participantDao.getParticipant(PageRequest.of(page, pageSize));
    }

    @Override
    public Participant getParticipant(Long id) {
        return participantDao.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Participant not found"));
    }
}
