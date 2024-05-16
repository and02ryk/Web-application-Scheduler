package com.example.conference.controllers;


import com.example.conference.models.Schedule;
import com.example.conference.services.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private ScheduleService scheduleService ;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public List<Schedule> getAllSchedules() {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<List<Schedule>> findByRoomId(@PathVariable Long roomId) {
        List<Schedule> schedules = scheduleService.getScheduleByRoomId(roomId);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }
}
