package com.sandeepkrp.cstalks.core.attendees.api;


import com.sandeepkrp.cstalks.core.attendees.models.Attendee;
import com.sandeepkrp.cstalks.core.attendees.models.AttendeesModel;

public interface AttendeeService {
    String addAttendee(Attendee attendee);
    AttendeesModel getAllAttendees();
    Attendee getAttendeeById (String id);
}
