package com.wedding.backend.service;

import com.wedding.backend.dto.RsvpRequest;
import com.wedding.backend.dto.RsvpStats;
import com.wedding.backend.model.Rsvp;
import com.wedding.backend.repository.RsvpRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RsvpService {
    private final RsvpRepository rsvpRepository;

    public RsvpService(RsvpRepository rsvpRepository) {
        this.rsvpRepository = rsvpRepository;
    }

    public boolean submitRsvp(RsvpRequest request) {

        Optional<Rsvp> existing = rsvpRepository
                .findByGuestNameIgnoreCase(request.getGuestName());

        Rsvp rsvp;

        if (existing.isPresent()) {
            rsvp = existing.get(); // UPDATE
        } else {
            rsvp = new Rsvp();     // CREATE
            rsvp.setGuestName(request.getGuestName());
        }

        applyRequest(rsvp, request);
        rsvpRepository.save(rsvp);

        return existing.isPresent(); // true = mise à jour
    }

    private void applyRequest(Rsvp rsvp, RsvpRequest request) {

        rsvp.setPresent(request.isPresent());
        rsvp.setEnfants(request.getEnfants());

        rsvp.setVegetarien(request.isVegetarien());
        rsvp.setHalal(request.isHalal());
        rsvp.setCasher(request.isCasher());
        rsvp.setSansAllergene(request.isSansAllergene());

        rsvp.setMairie(request.isMairie());
        rsvp.setEglise(request.isEglise());
        rsvp.setVinDHonneur(request.isVinDHonneur());
        rsvp.setReception(request.isReception());

        rsvp.setVehicule(request.getVehicule());
        rsvp.setCovoiturage(request.getCovoiturage());

        rsvp.setRemarque(request.getRemarque());
    }

    public List<Rsvp> findAll() {
        return rsvpRepository.findAll();
    }

    public void delete(Long id) {
        rsvpRepository.deleteById(id);
    }

    public RsvpStats getStats() {
        long total = rsvpRepository.count();

        return new RsvpStats(
                total,
                rsvpRepository.countByPresentTrue(),
                rsvpRepository.countByPresentFalse(),
                rsvpRepository.sumEnfants(),
                rsvpRepository.countByMairieTrue(),
                rsvpRepository.countByEgliseTrue(),
                rsvpRepository.countByVinDHonneurTrue(),
                rsvpRepository.countByReceptionTrue()
        );
    }

}
