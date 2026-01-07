package com.wedding.backend.service;

import com.wedding.backend.model.Guest;
import com.wedding.backend.repository.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findById(Long id) {
        return guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found"));
    }

    public Optional<Guest> findByEmail(String email){
        return guestRepository.findByEmail(email);
    }

    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    public void delete(Long id){
        guestRepository.deleteById(id);
    }
}
