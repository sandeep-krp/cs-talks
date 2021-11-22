package com.sandeepkrp.cstalks.core.talks.api;

import com.sandeepkrp.cstalks.core.talks.models.TalkModel;
import com.sandeepkrp.cstalks.core.talks.models.TalksFilter;
import com.sandeepkrp.cstalks.core.talks.models.TalksModel;

public interface TalksService {
    String addTalk(TalkModel talkModel);
    TalksModel getTalks(TalksFilter filter);
    TalkModel getTalkById(String id);
    TalkModel getTalkByTitle(String name);
    Boolean addAttendee(String talkId, String attendeeId);

}
