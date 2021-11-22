package com.sandeepkrp.cstalks.memory.attendees;


import com.sandeepkrp.cstalks.core.attendees.api.AttendeeService;
import com.sandeepkrp.cstalks.core.attendees.models.Attendee;
import com.sandeepkrp.cstalks.core.attendees.models.AttendeesModel;
import com.sandeepkrp.cstalks.core.exceptions.ResourceNotFound;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MemoryBaseAttendeeService implements AttendeeService {

    private Map<String, Attendee> attendees = new ConcurrentHashMap<>();

    @Override
    public String addAttendee(Attendee attendee) {
        if(attendee.getId() == null){
            attendee.setId("at-"+ UUID.randomUUID().toString());
        }
        this.attendees.put(attendee.getId(),attendee);
        return attendee.getId();
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
