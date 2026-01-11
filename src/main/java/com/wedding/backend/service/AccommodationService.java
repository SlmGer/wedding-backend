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
        accommodation.setName(accommodationRequest.getName());
        accommodation.setImageUrl(accommodationRequest.getImageUrl());
        //accommodation.setActive(accommodationRequest.isActive());
        accommodation.setDistanceKm(accommodationRequest.getDistanceKm());
        accommodation.setGoogleMapsUrl(accommodationRequest.getGoogleMapsUrl());
        accommodationRepository.save(accommodation);
        return accommodation;
    }

    public List<Accommodation> findAll(){
        return accommodationRepository.findAll();
    }

    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }
}
