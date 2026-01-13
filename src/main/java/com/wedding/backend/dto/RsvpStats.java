package com.wedding.backend.dto;

public record RsvpStats(
    long total,
    long present,
    long absent,
    long enfants,
    long vegetarien,
    long halal,
    long casher,
    long sansAllergene,
    long mairie,
    long eglise,
    long vindhonneur,
    long reception,
    long vehicule,
    long covoiturage
){}
