package com.example.conference.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "talks")
public class Talk {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "talk", cascade = CascadeType.ALL)
    private Set<Schedule> schedules = new HashSet();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_talks",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "talks_id", referencedColumnName = "id"))
    private Set<Talk> talks = new HashSet<Talk>();
}
