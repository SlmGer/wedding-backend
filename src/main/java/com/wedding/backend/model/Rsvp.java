package com.wedding.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "rsvp")
public class Rsvp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestName;
    private boolean present;
    private Integer enfants;

    // alimentation
    private boolean vegetarien;
    private boolean halal;
    private boolean casher;
    private boolean sansAllergene;

    // lieux
    private boolean mairie;
    private boolean eglise;
    private boolean vinDHonneur;
    private boolean reception;

    // transport
    private boolean vehicule;
    private boolean covoiturage;

    @Column(length = 500)
    private String remarque;

    private LocalDateTime respondedAt = LocalDateTime.now();

}
