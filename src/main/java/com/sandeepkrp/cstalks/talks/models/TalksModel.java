package com.sandeepkrp.cstalks.talks.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class TalksModel {
    private List<TalkModel> talks;

}
