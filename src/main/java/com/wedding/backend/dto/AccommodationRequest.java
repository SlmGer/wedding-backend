package com.wedding.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccommodationRequest {
    private String name;
    private String type;
    private String address;
    private String imageUrl;
    private String googleMapsUrl;
    private Integer distance;

    private boolean active = true;
}
