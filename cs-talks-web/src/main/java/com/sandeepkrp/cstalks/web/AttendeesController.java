package com.sandeepkrp.cstalks.web;

import com.sandeepkrp.cstalks.core.attendees.api.AttendeeService;
import com.sandeepkrp.cstalks.core.attendees.models.Attendee;
import com.sandeepkrp.cstalks.core.attendees.models.AttendeesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
