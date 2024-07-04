package com.krtopi.backend.qartel.event;

import com.krtopi.backend.qartel.business.BusinessEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }
    @GetMapping("/api/events")
    public List<EventEntity> getEventsByCity(@RequestParam String city) {
        return eventService.getEventsByCity(city);
    }

    @GetMapping("/api/events/{eventId}")
    public EventEntity getEventByEventId(@PathVariable String eventId) {
        return eventService.getEventByEventId(eventId);
    }
    @PostMapping("/api/events")
    public EventEntity createEvent(@RequestBody EventEntity event) {
        return eventService.createEvent(event);
    }
}
