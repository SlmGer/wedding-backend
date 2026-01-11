package com.wedding.backend.controller;

import com.wedding.backend.dto.RsvpRequest;
import com.wedding.backend.model.Rsvp;
import com.wedding.backend.service.RsvpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rsvp")
@CrossOrigin(origins = "https://mariage-gerardine-et-esaie.vercel.app")
public class RsvpController {

    private final RsvpService rsvpService;

    public RsvpController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> submit(@RequestBody RsvpRequest request) {

        boolean updated = rsvpService.submitRsvp(request);

        return ResponseEntity.ok(
                Map.of(
                        "updated", updated,
                        "message", updated
                                ? "Votre réponse a été mise à jour"
                                : "Merci pour votre réponse"
                )
        );
    }


    @GetMapping
    public List<Rsvp> getAll(){
        return rsvpService.findAll();
    }
}
