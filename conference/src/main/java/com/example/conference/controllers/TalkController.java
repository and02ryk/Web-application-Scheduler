package com.example.conference.controllers;

import com.example.conference.models.Schedule;
import com.example.conference.services.impl.UserServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.conference.models.Talk;
import com.example.conference.services.TalkService;
import com.example.conference.repositories.TalkRepository;

import java.util.List;

@RestController
@RequestMapping("/talks")
public class TalkController {

    private TalkRepository talkRepository;
    private Schedule schedule;
    private TalkService talkService;

    public TalkController(TalkService talkService, TalkRepository talkRepository) {
        super();
        this.talkService = talkService;
        this.talkRepository = talkRepository;
    }

    @PostMapping
    public ResponseEntity<Talk> saveTalk(@RequestBody Talk talk) {
        boolean isAvailable = talkRepository.checkAvailability(schedule.getRoomId(), schedule.getStartTime(), schedule.getEndTime(), schedule.getDate());
        if (isAvailable) {
            return new ResponseEntity<Talk>(talkService.saveTalk(talk), HttpStatus.CREATED);
        }
        else
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    @GetMapping
    public List<Talk> getAllTalks() {
        return talkService.getAllTalks();
    }

    @GetMapping({"{id}"})
    public ResponseEntity<Talk> getTalkById(@PathVariable("id") long talkId) {
        return new ResponseEntity<Talk>(talkService.getTalkById(talkId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Talk> updateTalk(@PathVariable("id") long id, @RequestBody Talk talk) {
        return new ResponseEntity<>(talkService.updateTalk(talk, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTalk(@PathVariable("id") long id) {
        talkService.deleteTalk(id);
        return new ResponseEntity<String>("Talk deleted!", HttpStatus.OK);
    }
}
