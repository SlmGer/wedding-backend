package com.wedding.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "guest")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToOne(mappedBy = "guest", cascade = CascadeType.ALL)
    private Rsvp rsvp;
}
