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

    public Accommodation create(AccommodationRequest request) {
        Accommodation accommodation = new Accommodation();
        applyRequest(accommodation, request);
        return accommodationRepository.save(accommodation);
    }

    public Accommodation update(Long id, AccommodationRequest request) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hébergement introuvable"));

        applyRequest(accommodation, request);
        return accommodationRepository.save(accommodation);
    }

    private void applyRequest(Accommodation accommodation, AccommodationRequest request) {
        accommodation.setName(request.getName());
        accommodation.setType(request.getType());
        accommodation.setAddress(request.getAddress());
        accommodation.setImageUrl(request.getImageUrl());
        accommodation.setGoogleMapsUrl(request.getGoogleMapsUrl());
        accommodation.setBookingUrl(request.getBookingUrl());
        accommodation.setDistance(request.getDistance());

        if (request.isActive()) {
            accommodation.setActive(true);
        }
    }

    public List<Accommodation> findAll(){
        return accommodationRepository.findAll();
    }

    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }
}
