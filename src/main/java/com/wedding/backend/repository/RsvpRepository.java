package com.wedding.backend.repository;

import com.wedding.backend.model.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RsvpRepository extends JpaRepository<Rsvp, Long> {
    Optional<Rsvp> findByGuestNameIgnoreCase(String guestName);

    boolean existsByGuestNameIgnoreCase(String guestName);

    long countByPresentTrue();
    long countByPresentFalse();
    long countByMairieTrue();
    long countByEgliseTrue();
    long countByVinDHonneurTrue();
    long countByReceptionTrue();

    @Query("select coalesce(sum(r.enfants), 0) from Rsvp r")
    long sumEnfants();
}
