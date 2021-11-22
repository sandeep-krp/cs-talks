package com.sandeepkrp.cstalks.core.talks.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TalksFilter {
    private String id;
    private String title;
    private String room;


}
