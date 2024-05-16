package com.example.conference.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_talks",
            joinColumns = @JoinColumn(name = "talks_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "users_id", referencedColumnName = "id"))
    private Set<User> users = new HashSet<User>();
}
