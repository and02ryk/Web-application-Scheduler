package com.example.conference.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "number")
    private String number;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private Set<Schedule> schedules = new HashSet();

    public Set<Schedule> getSchedules() {
        return schedules;
    }


}
