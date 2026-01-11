package com.wedding.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
