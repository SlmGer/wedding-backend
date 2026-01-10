package com.wedding.backend.controller;

import com.wedding.backend.dto.AccommodationRequest;
import com.wedding.backend.model.Accommodation;
import com.wedding.backend.service.AccommodationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/accommodations")
@CrossOrigin(origins = "http://localhost:4200")
public class AccommodationController {
    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public List<Accommodation> getAll(){
        return accommodationService.findAll();
    }

    @GetMapping("/{id}")
    public Accommodation getOne(@PathVariable Long id) {
        return accommodationService.findById(id);
    }

    @PostMapping
    public Accommodation add(@RequestBody AccommodationRequest acc){
        return accommodationService.save(acc);
    }

    @PutMapping("/{id}")
    public Accommodation update(
            @PathVariable Long id,
            @RequestBody AccommodationRequest accommodation) {
        return accommodationService.update(id, accommodation);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        accommodationService.deleteById(id);
    }
}
