package com.wedding.backend.repository;

import com.wedding.backend.model.EventInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventInfoRepository extends JpaRepository<EventInfo,Long> {
}
