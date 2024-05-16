package com.example.conference.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table (name = "Schedule")
public class Schedule {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getEndTime() {
        return endTime;
    }


    public LocalTime getStartTime() {
        return startTime;
    }


    public long getRoomId() {
        return room.getId();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "endTime")
    private LocalTime endTime;

    @Column(name = "startTime")
    private LocalTime startTime;

    @ManyToOne
    @JoinColumn(name = "talk_id")
    private Talk talk;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

}
