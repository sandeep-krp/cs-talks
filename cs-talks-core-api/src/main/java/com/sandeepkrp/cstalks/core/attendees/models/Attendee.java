package com.sandeepkrp.cstalks.core.attendees.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Attendee {
    private String id;
    private String name;
    private String company;
    private String email;
    private String registered;

}
