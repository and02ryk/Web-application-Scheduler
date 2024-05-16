package com.example.conference.services.impl;

import com.example.conference.exception.ResourceNotFoundException;
import com.example.conference.models.Room;
import com.example.conference.models.Schedule;
import com.example.conference.repositories.RoomRepository;
import com.example.conference.repositories.ScheduleRepository;
import com.example.conference.services.ScheduleService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private RoomRepository roomRepository;
    private ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, RoomRepository roomRepository) {
        this.scheduleRepository = scheduleRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getScheduleByRoomId(long id) {
        return scheduleRepository.findByRoomId(id);
    }

}
