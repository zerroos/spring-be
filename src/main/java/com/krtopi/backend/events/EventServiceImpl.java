package com.krtopi.backend.events;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    private EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    public void saveEvent(EventEntity event){
        this.eventRepository.save(event);
    }
    public void deleteEvent(String id){
        this.eventRepository.deleteById(id);
    }
    public List<EventEntity> getAllEventsByUser(Long id){
        return this.eventRepository.findByPosterId(id);
    }
    public List<EventEntity> getAllEvents(){
        return this.eventRepository.findAll();
    }
    public List<EventEntity> getEventByTag(String tag){
        return this.eventRepository.findByTagsContaining(tag);
    }
    public List<EventEntity> getEventByLocation(String location){
        return this.eventRepository.findByLocation(location);
    }
    public List<EventEntity> getMostRecentEvents(){
        Pageable pageable = PageRequest.of(0, 10);
        return this.eventRepository.findAllByOrderByCreatedAtDesc(pageable);
    }
    public List<EventEntity> getMostRecentAtLocation(String location, int count){
        Pageable pageable = PageRequest.of(0, count);
        return this.eventRepository.findByLocationOrderByCreatedAtDesc(location, pageable);
    }
    public List<EventEntity> getByTitle(String title){
        return this.eventRepository.findByTitleRegex(title);
    }
    public List<EventEntity> getByDescription(String description){
        return this.eventRepository.findByDescriptionRegex(description);
    }
}
