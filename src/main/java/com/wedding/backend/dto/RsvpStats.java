package com.wedding.backend.dto;

public record RsvpStats(
    long total,
    long present,
    long absent,
    long enfants,
    long mairie,
    long eglise,
    long vindhonneur,
    long reception
){}
