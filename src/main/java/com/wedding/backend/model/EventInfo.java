package com.wedding.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "event_info")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EventInfo {
    @Id
    private Long id = 1L;

    private String title;
    private String description;
    private String dateTimeIso;
    private String venueName;
    private String venueAddress;
    private String schedule;
    private String dressCode;
    private String theme;
    private String giftListUrl;
}
