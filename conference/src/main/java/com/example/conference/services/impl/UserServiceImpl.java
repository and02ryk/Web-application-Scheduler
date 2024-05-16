package com.example.conference.services.impl;

import com.example.conference.exception.ResourceNotFoundException;
import com.example.conference.models.User;
import com.example.conference.repositories.UserRepository;
import com.example.conference.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
    }

    @Override
    public User updateUser(User user, long id) {
        User exictingUser = userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));

        exictingUser.setLogin(user.getLogin());
        exictingUser.setPassword(user.getPassword());
        exictingUser.setRole(user.getRole());
        exictingUser.setFirstName(user.getFirstName());
        exictingUser.setLastName(user.getLastName());

        userRepository.save(exictingUser);

        return exictingUser;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(id);
    }

}

