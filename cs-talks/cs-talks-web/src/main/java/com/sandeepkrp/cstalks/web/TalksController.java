package com.sandeepkrp.cstalks.web;

import com.sandeepkrp.cstalks.core.talks.models.TalkModel;
import com.sandeepkrp.cstalks.core.talks.models.TalksFilter;
import com.sandeepkrp.cstalks.core.talks.models.TalksModel;
import com.sandeepkrp.cstalks.core.talks.api.TalksService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TalksController {

    @Autowired
    private TalksService talksService;

    @Operation(summary = "Adds a new Talk in the system")
    @PostMapping("/talks")
    public void addTalk(@RequestBody TalkModel talkModel) {
        this.talksService.addTalk(talkModel);
    }

    @Operation(summary = "Gets the talks based on its attributes")
    @GetMapping("/talks")
    public TalksModel getTalks(@RequestParam(required = false) String id,
                               @RequestParam(required = false) String title,
                               @RequestParam(required = false) String room) {
        return this.talksService.getTalks(TalksFilter.builder().id(id).title(title).room(room).build());
    }

    @Operation(summary = "Adds an attendee to a talk")
    @PutMapping("/talks/{talkId}/attendees/{attendeeId}")
    public void addAttendeeToTalk(@PathVariable String talkId, @PathVariable String attendeeId) {
        this.talksService.addAttendee(talkId,attendeeId);

    }
}
