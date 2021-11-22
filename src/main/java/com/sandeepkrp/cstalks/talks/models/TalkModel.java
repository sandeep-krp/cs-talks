package com.sandeepkrp.cstalks.talks.models;

import com.sandeepkrp.cstalks.attendees.models.Attendee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TalkModel {
    private String id;
    private String title;
    private String talkAbstract;
    private String room;
    private SpeakerModel speaker;
    private List<Attendee> attendees = new ArrayList<>();

}
