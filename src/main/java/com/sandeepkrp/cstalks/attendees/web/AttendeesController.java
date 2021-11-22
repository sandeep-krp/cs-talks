package com.sandeepkrp.cstalks.attendees.web;

import com.sandeepkrp.cstalks.attendees.models.Attendee;
import com.sandeepkrp.cstalks.attendees.models.AttendeesModel;
import com.sandeepkrp.cstalks.attendees.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class AttendeesController {


    @Autowired
    private AttendeeService attendeeService;

    @PostMapping("/attendees")
    public void addAttendees(@RequestBody Attendee attendee) {
        this.attendeeService.addAttendee(attendee);
    }

    @GetMapping("/attendees")
    public AttendeesModel getAttendees() {
        return this.attendeeService.getAllAttendees();
    }
}
