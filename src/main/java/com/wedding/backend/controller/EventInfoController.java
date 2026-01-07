package com.wedding.backend.controller;

import com.wedding.backend.model.EventInfo;
import com.wedding.backend.service.EventInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EventInfoController {
    private final EventInfoService eventInfoService;

    @GetMapping
    public ResponseEntity<EventInfo> get(){
        return eventInfoService.get().map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EventInfo save(@RequestBody EventInfo eventInfo){
        return eventInfoService.save(eventInfo);
    }
}
