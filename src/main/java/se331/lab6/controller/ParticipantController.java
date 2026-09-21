package se331.lab6.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se331.lab6.service.ParticipantService;
import se331.lab6.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("/participants")
    ResponseEntity<?> getParticipants() {
        return ResponseEntity.ok(
                LabMapper.INSTANCE.getParticipantDetailDTO(participantService.getAllParticipant()));
    }

    @GetMapping("/participants/{id}")
    ResponseEntity<?> getParticipant(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                LabMapper.INSTANCE.getParticipantDetailDTO(participantService.getParticipant(id)));
    }
}
