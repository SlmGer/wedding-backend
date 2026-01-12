package com.wedding.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RsvpRequest {
    private String guestName;

    private boolean present;
    private Integer enfants;

    private boolean vegetarien;
    private boolean halal;
    private boolean casher;
    private boolean sansAllergene;

    private boolean mairie;
    private boolean eglise;
    private boolean vinDHonneur;
    private boolean reception;

    private Boolean vehicule;
    private Boolean covoiturage;

    private String remarque;

}
