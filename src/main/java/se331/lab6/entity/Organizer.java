package se331.lab6.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Organizer {
    Long id;
    String name;
    String address;
}
