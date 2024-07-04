package com.krtopi.backend.qartel.event;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "events")
public class EventEntity {
    @Id
    private String eventId;
    private String title;
    private String description;
    private String[] images;
    private Date startDate;
    private Date endDate;
    private Date startTime;
    private Date endTime;
    private String location;
}
