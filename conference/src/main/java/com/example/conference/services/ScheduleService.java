package com.example.conference.services;

import com.example.conference.models.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {
    List<Schedule> getAllSchedules();
    List<Schedule> getScheduleByRoomId(long id);
}
