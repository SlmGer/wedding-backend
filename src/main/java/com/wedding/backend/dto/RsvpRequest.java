package com.wedding.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RsvpRequest {
    private String guestName;
    //private String email;

    private boolean present;
    private Integer enfants;

    private boolean vegetarien;
    private boolean halal;
    private boolean casher;
    private boolean sansAllergenes;

    private boolean mairie;
    private boolean eglise;
    private boolean vinDHonneur;
    private boolean reception;

    private boolean vehicule;
    private boolean covoiturage;

    private String remarque;

}
