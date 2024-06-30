package com.krtopi.backend.events;

import com.krtopi.backend.post.PostEntity;
import com.krtopi.backend.post.PostService;
import com.krtopi.backend.utils.StatusOnlyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class EventController {

    EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping(path="/events")
    public ResponseEntity<StatusOnlyResponse> createEvent(@RequestBody EventEntity event) {
        try {
            this.eventService.saveEvent(event);
            return new ResponseEntity<>(new StatusOnlyResponse("Success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(path="/events", params="eventId")
    public ResponseEntity<StatusOnlyResponse> deleteEvent(@RequestParam(name = "eventId") String eventId) {
        try {
            this.eventService.deleteEvent(eventId);
            return new ResponseEntity<>(new StatusOnlyResponse("Success"), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/events", params = {"location", "count"})
    public ResponseEntity<List<EventEntity>> getMostRecentEventByLocationLimit(@RequestParam(name = "location") String location, @RequestParam(name = "count") int count) {
        try {
            List<EventEntity> events = this.eventService.getMostRecentAtLocation(location, count);
            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/events", params = "title")
    public ResponseEntity<List<EventEntity>> getMostRecentEventsByTitleRegex(@RequestParam(name = "title") String title) {
        try {
            List<EventEntity> events = this.eventService.getByTitle(title);
            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/events")
    public ResponseEntity<List<EventEntity>> getAllEvents() {
        try {
            List<EventEntity> events = this.eventService.getAllEvents();
            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/events", params = "desc")
    public ResponseEntity<List<EventEntity>> getMostRecentEventByDescriptionRegex(@RequestParam(name = "desc") String keyword) {
        try {
            List<EventEntity> events = this.eventService.getByDescription(keyword);
            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/events", params = "location")
    public ResponseEntity<List<EventEntity>> getMostRecentEventsByLocation(@RequestParam(name = "location") String location) {
        try {
            List<EventEntity> events = this.eventService.getEventByLocation(location);
            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/events", params = "tag")
    public ResponseEntity<List<EventEntity>> getMostRecentEventsByTags(@RequestParam(name = "tag") String tag) {
        try {
            List<EventEntity> events = this.eventService.getEventByTag(tag);
            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
