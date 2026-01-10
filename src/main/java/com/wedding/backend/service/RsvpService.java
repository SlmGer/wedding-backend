package com.wedding.backend.service;

import com.wedding.backend.dto.RsvpRequest;
import com.wedding.backend.dto.RsvpStats;
import com.wedding.backend.model.Rsvp;
import com.wedding.backend.repository.RsvpRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RsvpService {
    //private final GuestRepository guestRepository;
    private final RsvpRepository rsvpRepository;

    public RsvpService(RsvpRepository rsvpRepository) {
        //this.guestRepository = guestRepository;
        this.rsvpRepository = rsvpRepository;
    }

    public Rsvp updateById(Long id, RsvpRequest updated){
        Rsvp existing = rsvpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));

        existing = this.setValues(existing, updated);

        return rsvpRepository.save(existing);
    }

    public List<Rsvp> findAll() {
        return rsvpRepository.findAll();
    }

    public Rsvp findById(Long id){
        return rsvpRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id) {
        rsvpRepository.deleteById(id);
    }

    public Rsvp setValues(Rsvp rsvp, RsvpRequest request) {
        rsvp.setGuestName(request.getGuestName());

        rsvp.setPresent(request.isPresent());
        rsvp.setEnfants(request.getEnfants());

        rsvp.setVegetarien(request.isVegetarien());
        rsvp.setHalal(request.isHalal());
        rsvp.setCasher(request.isCasher());
        rsvp.setSansAllergenes(request.isSansAllergenes());

        rsvp.setMairie(request.isMairie());
        rsvp.setEglise(request.isEglise());
        rsvp.setVinDHonneur(request.isVinDHonneur());
        rsvp.setReception(request.isReception());

        rsvp.setVehicule(request.isVehicule());
        rsvp.setCovoiturage(request.isCovoiturage());

        rsvp.setRemarque(request.getRemarque());

        rsvp.setRespondedAt(LocalDateTime.now());

        return rsvp;
    }

    public Rsvp saveOrUpdate(RsvpRequest rsvp) {

        return rsvpRepository
            .findByGuestNameIgnoreCase(rsvp.getGuestName())
            .map(existing -> {
                // UPDATE
                existing = this.setValues(existing, rsvp);
                return rsvpRepository.save(existing);
            })
            .orElseGet(() -> {
                // CREATE
                Rsvp newRsvp = new Rsvp();
                newRsvp = this.setValues(newRsvp, rsvp);
                newRsvp.setRespondedAt(LocalDateTime.now());
                return rsvpRepository.save(newRsvp);
            });
    }

    public boolean existsByGuestName(String guestName){
        return rsvpRepository.existsByGuestNameIgnoreCase(guestName);
    }

    public RsvpStats getStats() {
        long total = rsvpRepository.count();

        return new RsvpStats(
                total,
                rsvpRepository.countByPresentTrue(),
                rsvpRepository.countByPresentFalse(),
                rsvpRepository.sumEnfants(),
                rsvpRepository.countByMairieTrue(),
                rsvpRepository.countByVinDHonneurTrue(),
                rsvpRepository.countByEgliseTrue(),
                rsvpRepository.countByReceptionTrue()
        );
    }

}
