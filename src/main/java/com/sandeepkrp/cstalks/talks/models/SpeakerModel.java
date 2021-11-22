package com.sandeepkrp.cstalks.talks.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SpeakerModel {
    private String name;
    private String email;
    private String company;
    private String bio;
}
