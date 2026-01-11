package com.wedding.backend.controller;

import com.wedding.backend.dto.RsvpRequest;
import com.wedding.backend.model.Rsvp;
import com.wedding.backend.service.RsvpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rsvp")
@CrossOrigin(origins = "https://mariage-gerardine-et-esaie.vercel.app")
public class RsvpController {

    private final RsvpService rsvpService;

    public RsvpController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @PostMapping
    public ResponseEntity<Void> submit(@RequestBody RsvpRequest request){
        rsvpService.submitRsvp(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Rsvp> getAll(){
        return rsvpService.findAll();
    }
}
