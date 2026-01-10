package com.wedding.backend.controller;

import com.wedding.backend.model.Guest;
import com.wedding.backend.repository.GuestRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CrossOrigin("*")
public class RootController {
    
    private final GuestRepository guestRepository;
    
    public RootController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
    
    @GetMapping("/")
    public List<Guest> home() {
        return guestRepository.findAll();
    }
}
