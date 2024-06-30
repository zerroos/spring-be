package com.krtopi.backend.events;

import java.util.List;

public interface EventService {
    void saveEvent(EventEntity event);
    void deleteEvent(String id);
    List<EventEntity> getAllEvents();
    List<EventEntity> getEventByTag(String tag);
    List<EventEntity> getEventByLocation(String location);
    List<EventEntity> getMostRecentEvents();
    List<EventEntity> getMostRecentAtLocation(String location, int count);
    List<EventEntity> getByTitle(String title);
    List<EventEntity> getByDescription(String description);
}
