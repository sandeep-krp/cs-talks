package com.sandeepkrp.cstalks.attendees.service;

import com.sandeepkrp.cstalks.attendees.models.Attendee;
import com.sandeepkrp.cstalks.attendees.models.AttendeesModel;

public interface AttendeeService {
    void addAttendee(Attendee attendee);
    AttendeesModel getAllAttendees();
    Attendee getAttendeeById (String id);
}
