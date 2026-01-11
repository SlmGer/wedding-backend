package com.wedding.backend.controller;

import com.wedding.backend.model.Guest;
import com.wedding.backend.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://mariage-gerardine-et-esaie.vercel.app")
public class GuestController {

    private final GuestService guestService;

    @GetMapping
    public List<Guest> getAllGuests() {
        return guestService.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable Long id) {
        return guestService.findById(id);
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.save(guest);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        guest.setId(id);
        return guestService.save(guest);
    }

    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable Long id) {
        guestService.delete(id);
    }
}
