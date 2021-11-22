package com.sandeepkrp.cstalks.talks.service;

import com.sandeepkrp.cstalks.attendees.models.Attendee;
import com.sandeepkrp.cstalks.talks.models.TalkModel;
import com.sandeepkrp.cstalks.talks.models.TalksFilter;
import com.sandeepkrp.cstalks.talks.models.TalksModel;

public interface TalksService {
    void addTalk(TalkModel talkModel);
    TalksModel getTalks(TalksFilter filter);
    TalkModel getTalkById(String id);
    TalkModel getTalkByTitle(String name);
    void addAttendee(String talkId, String attendeeId);

}
