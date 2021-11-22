package com.sandeepkrp.cstalks.attendees.service;

import com.sandeepkrp.cstalks.attendees.models.Attendee;
import com.sandeepkrp.cstalks.attendees.models.AttendeesModel;
import com.sandeepkrp.cstalks.exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MemoryBaseAttendeeService implements AttendeeService{

    private Map<String, Attendee> attendees = new ConcurrentHashMap<>();

    @Override
    public void addAttendee(Attendee attendee) {
        if(attendee.getId() == null){
            attendee.setId("at-"+ UUID.randomUUID().toString());
        }
        this.attendees.put(attendee.getId(),attendee);
    }

    @Override
    public AttendeesModel getAllAttendees() {
        return new AttendeesModel(this.attendees.values());
    }

    @Override
    public Attendee getAttendeeById(String id) {
        if (!this.attendees.containsKey(id)){
            throw new ResourceNotFound();
        }
        return this.attendees.get(id);
    }
}
