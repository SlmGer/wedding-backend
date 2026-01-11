package com.wedding.backend.controller;

import com.wedding.backend.model.Rsvp;
import com.wedding.backend.service.RsvpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/rsvp")
@CrossOrigin(origins = "https://mariage-gerardine-et-esaie.vercel.app")
public class AdminRsvpController {

    private final RsvpService rsvpService;

    public AdminRsvpController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @GetMapping
    public List<Rsvp> getAll() {
        return rsvpService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        rsvpService.delete(id);
    }
}
