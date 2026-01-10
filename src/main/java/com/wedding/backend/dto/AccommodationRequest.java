package com.wedding.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccommodationRequest {
    private String name;
    private String type;
    private String address;
    private String distance;
    private String googleMapsUrl;
    private String bookingUrl;
    private String imageUrl;

    private boolean active = true;
}
