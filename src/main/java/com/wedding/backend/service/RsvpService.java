package com.wedding.backend.service;

import com.wedding.backend.dto.RsvpRequest;
import com.wedding.backend.model.Guest;
import com.wedding.backend.model.Rsvp;
import com.wedding.backend.repository.GuestRepository;
import com.wedding.backend.repository.RsvpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RsvpService {
    private final GuestRepository guestRepository;
    private final RsvpRepository rsvpRepository;

    public RsvpService(GuestRepository guestRepository, RsvpRepository rsvpRepository) {
        this.guestRepository = guestRepository;
        this.rsvpRepository = rsvpRepository;
    }

    public void submitRsvp(RsvpRequest request){
        // 1. Guest create or find
        Guest guest = guestRepository
                .findByEmail(request.getEmail())
                .orElseGet(() -> {
                    Guest g = new Guest();
                    g.setNom(request.getNom());
                    g.setEmail(request.getEmail());
                    return guestRepository.save(g);
                });

        // 2. RSVP create or update
        Rsvp rsvp = rsvpRepository
                .findByGuestId(guest.getId())
                .orElse(new Rsvp());

        rsvp.setGuest(guest);
        guest.setRsvp(rsvp);
        rsvp.setPresent(request.isPresent());
        rsvp.setEnfants(request.getEnfants());

        rsvp.setVegetarien(request.isVegetarien());
        rsvp.setHalal(request.isHalal());
        rsvp.setCasher(request.isCasher());
        rsvp.setSansAllergene(request.isSansAllergene());

        rsvp.setMairie(request.isMairie());
        rsvp.setEglise(request.isEglise());
        rsvp.setReception(request.isReception());

        rsvp.setVehicule(request.getVehicule());
        rsvp.setCovoiturage(request.getCovoiturage());

        rsvp.setRemarque(request.getRemarque());

        guestRepository.save(guest);
        rsvpRepository.save(rsvp);
    }

    public List<Rsvp> findAll() {
        return rsvpRepository.findAll();
    }

    public void delete(Long id) {
        rsvpRepository.deleteById(id);
    }
}
