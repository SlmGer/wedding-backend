package com.wedding.backend.repository;

import com.wedding.backend.model.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RsvpRepository extends JpaRepository<Rsvp, Long> {
    Optional<Rsvp> findByGuestId(Long guestId);
}
