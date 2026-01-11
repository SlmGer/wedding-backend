package com.wedding.backend.controller;

import com.wedding.backend.dto.AccommodationRequest;
import com.wedding.backend.model.Accommodation;
import com.wedding.backend.service.AccommodationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/accommodations")
@CrossOrigin(origins = "https://mariage-gerardine-et-esaie.vercel.app")
public class AccommodationController {
    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public List<Accommodation> getAll(){
        return accommodationService.findAll();
    }

    @PostMapping
    public Accommodation add(@RequestBody AccommodationRequest acc){
        return accommodationService.save(acc);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        accommodationService.deleteById(id);
    }
}
