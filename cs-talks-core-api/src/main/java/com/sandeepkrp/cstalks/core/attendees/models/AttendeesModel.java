package com.sandeepkrp.cstalks.core.attendees.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class AttendeesModel {

    Collection<Attendee> attendees;
}
