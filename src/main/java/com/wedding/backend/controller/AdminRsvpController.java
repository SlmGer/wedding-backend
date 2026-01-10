package com.wedding.backend.controller;

import com.wedding.backend.dto.RsvpRequest;
import com.wedding.backend.dto.RsvpResponse;
import com.wedding.backend.dto.RsvpStats;
import com.wedding.backend.model.Rsvp;
import com.wedding.backend.service.RsvpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rsvp")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminRsvpController {

    private final RsvpService rsvpService;

    public AdminRsvpController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @GetMapping
    public List<Rsvp> getAll() {
        return rsvpService.findAll();
    }

    @GetMapping("/{id}")
    public Rsvp getOne(@PathVariable Long id) {
        return rsvpService.findById(id);
    }

    @PostMapping
    public ResponseEntity<RsvpResponse> submit(@RequestBody RsvpRequest rsvp){
        boolean alreadyExists = rsvpService.existsByGuestName(rsvp.getGuestName());

        Rsvp saved = rsvpService.saveOrUpdate(rsvp);
        return ResponseEntity.ok(
                new RsvpResponse(
                        alreadyExists
                            ? "Votre réponse a été mise à jour"
                            : "Merci pour votre réponse",
                        alreadyExists
                )
        );
    }

    @PutMapping("/{id}")
    public Rsvp update(
            @PathVariable Long id,
            @RequestBody RsvpRequest rsvp) {
        return rsvpService.updateById(id, rsvp);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        rsvpService.deleteById(id);
    }

    @GetMapping("/stats")
    public RsvpStats stats() {
        return rsvpService.getStats();
    }
}
