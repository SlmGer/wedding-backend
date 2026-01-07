package com.wedding.backend.service;

import com.wedding.backend.model.EventInfo;
import com.wedding.backend.repository.EventInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventInfoService {
    private final EventInfoRepository eventInfoRepository;

    public Optional<EventInfo> get(){
        return  eventInfoRepository.findById(1L);
    }

    public EventInfo save(EventInfo info){
        info.setId(1L);
        return eventInfoRepository.save(info);
    }
}
