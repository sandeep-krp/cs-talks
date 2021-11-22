package com.sandeepkrp.cstalks.memory.talks;

import com.sandeepkrp.cstalks.core.attendees.api.AttendeeService;
import com.sandeepkrp.cstalks.core.exceptions.ResourceNotFound;
import com.sandeepkrp.cstalks.core.talks.api.TalksService;
import com.sandeepkrp.cstalks.core.talks.models.TalkModel;
import com.sandeepkrp.cstalks.core.talks.models.TalksFilter;
import com.sandeepkrp.cstalks.core.talks.models.TalksModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MemoryBasedTalkService implements TalksService {

    private final ConcurrentHashMap<String, TalkModel> talks = new ConcurrentHashMap<>();

    @Autowired
    private AttendeeService attendeeService;


    @Override
    public void addTalk(TalkModel talkModel) {
        if (talkModel.getId() == null) {
            talkModel.setId("tl-" + UUID.randomUUID());
        }

        // Set empty list instead of adding null
        if (talkModel.getAttendees() == null) {
            talkModel.setAttendees(new ArrayList<>());
        }
        this.talks.put(talkModel.getId(), talkModel);
    }

    @Override
    public TalksModel getTalks(TalksFilter filter) {
        Stream<TalkModel> talksStream = this.talks.values().stream();
        if (filter.getId() != null) {
            talksStream = talksStream.filter(talk -> talk.getId().equals(filter.getId()));
        }

        if (filter.getTitle() != null) {
            talksStream = talksStream.filter(talk -> talk.getTitle().equals(filter.getTitle()));
        }

        if (filter.getRoom() != null) {
            talksStream = talksStream.filter(talk -> talk.getRoom().equals(filter.getRoom()));
        }
        return new TalksModel(talksStream.collect(Collectors.toList()));
    }

    @Override
    public TalkModel getTalkById(String id) {

        if (talks.containsKey(id)) {
            return talks.get(id);
        }
        throw new ResourceNotFound();
    }

    @Override
    public TalkModel getTalkByTitle(String title) {
        return this.talks.values().stream().filter(talk -> talk.getTitle().
                equals(title)).findFirst().
                orElseThrow(ResourceNotFound::new);
    }

    @Override
    public void addAttendee(String talkId, String attendeeId) {
        if (!this.talks.containsKey(talkId)) {
            throw new ResourceNotFound();
        }

        // A check could be added to see if the attendee is already present
        this.talks.get(talkId).getAttendees().
                add(this.attendeeService.getAttendeeById(attendeeId));
    }
}
