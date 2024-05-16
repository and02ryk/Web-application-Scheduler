package com.example.conference.services;

import com.example.conference.models.Talk;

import java.util.List;

public interface TalkService {
    Talk saveTalk(Talk talk);
    List<Talk> getAllTalks();
    Talk getTalkById(long id);
    Talk updateTalk(Talk talk, long id);
    void deleteTalk(long id);
}
