package com.example.conference.services.impl;

import com.example.conference.exception.ResourceNotFoundException;
import com.example.conference.models.Talk;
import com.example.conference.repositories.TalkRepository;
import com.example.conference.services.TalkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkServiceImpl implements TalkService {

    private TalkRepository talkRepository;

    public TalkServiceImpl(TalkRepository talkRepository) {
        this.talkRepository = talkRepository;
    }

    @Override
    public Talk saveTalk(Talk talk) {

        return talkRepository.save(talk);
    }

    @Override
    public List<Talk> getAllTalks() {

        return talkRepository.findAll();
    }

    @Override
    public Talk getTalkById(long id) {
        return talkRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Talk", "id", id));
    }

    @Override
    public Talk updateTalk(Talk talk, long id) {
        Talk exictingTalk = talkRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Talk", "id", id));

        exictingTalk.setName(talk.getName());
        exictingTalk.setDescription(talk.getDescription());

        talkRepository.save(exictingTalk);
        return exictingTalk;
    }

    @Override
    public void deleteTalk(long id) {
        talkRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Talk", "id", id));
        talkRepository.deleteById(id);
    }
}
