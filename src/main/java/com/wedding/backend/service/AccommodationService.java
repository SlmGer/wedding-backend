package com.wedding.backend.service;

import com.wedding.backend.dto.AccommodationRequest;
import com.wedding.backend.model.Accommodation;
import com.wedding.backend.repository.AccommodationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;

    public AccommodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public Accommodation save(AccommodationRequest accommodationRequest) {
        Accommodation accommodation = new Accommodation();
        accommodation = this.setValues(accommodation, accommodationRequest);
        accommodationRepository.save(accommodation);
        return accommodation;
    }

    public Accommodation update(Long id, AccommodationRequest updated) {
        Accommodation existing = accommodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));

        existing = this.setValues(existing, updated);

        return accommodationRepository.save(existing);
    }


    public List<Accommodation> findAll(){
        return accommodationRepository.findAll();
    }

    public Accommodation findById(Long id){
        return accommodationRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

    public Accommodation setValues(Accommodation accommodation, AccommodationRequest accommodationRequest) {
        accommodation.setName(accommodationRequest.getName());
        accommodation.setType(accommodationRequest.getType());
        accommodation.setAddress(accommodationRequest.getAddress());
        accommodation.setDistance(accommodationRequest.getDistance());
        accommodation.setGoogleMapsUrl(accommodationRequest.getGoogleMapsUrl());
        accommodation.setBookingUrl(accommodationRequest.getBookingUrl());
        accommodation.setImageUrl(accommodationRequest.getImageUrl());
        accommodation.setActive(accommodationRequest.isActive());

        return accommodation;
    }
}
