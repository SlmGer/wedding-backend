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

    @Column(unique = true, nullable = false)
    private String guestName;

    /*@OneToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;*/

    private boolean present;

    private Integer enfants;

    // alimentation
    private boolean vegetarien;
    private boolean halal;
    private boolean casher;
    private boolean sansAllergenes;

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
