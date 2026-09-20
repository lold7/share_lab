# Entity Class Diagram — Lab 8 (JPA Relationship)

```mermaid
classDiagram
    class Event {
        -Long id
        -String category
        -String title
        -String description
        -String location
        -String date
        -String time
        -Boolean petsAllowed
        -Organizer organizer
        -List~Participant~ participants
    }

    class Organizer {
        -Long id
        -String name
        -List~Event~ ownEvents
    }

    class Participant {
        -Long id
        -String name
        -String telNo
        -List~Event~ eventHistories
    }

    Organizer "1" --> "0..*" Event : ownEvents
    Event "0..*" --> "1" Organizer : organizer
    Event "0..*" <--> "0..*" Participant : participants / eventHistories
```

## Relationship mapping

| Relationship | Owning side | Inverse side | Annotation |
|---|---|---|---|
| Organizer — Event | `Event.organizer` | `Organizer.ownEvents` | `@ManyToOne` / `@OneToMany(mappedBy = "organizer")` |
| Event — Participant | `Event.participants` | `Participant.eventHistories` | `@ManyToMany` / `@ManyToMany(mappedBy = "participants")` |

- **One Organizer owns many Events** (1 : N) — the foreign key `organizer_id` lives in the `event` table.
- **An Event has many Participants and a Participant joins many Events** (N : N) — Hibernate creates the join table `event_participants`.
