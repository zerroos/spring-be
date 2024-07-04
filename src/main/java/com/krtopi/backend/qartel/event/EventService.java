package com.krtopi.backend.qartel.event;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public List<EventEntity> getEventsByCity(String city){
    return this.eventRepository.findByLocation(city);
    }

    public EventEntity getEventByEventId(String id){
        return this.eventRepository.findByEventId(id);
    }
    public EventEntity createEvent(EventEntity event){
        return this.eventRepository.save(event);
    }
}
