package com.project.boxinator.services;

import com.project.boxinator.exceptions.UserNotFoundException;
import com.project.boxinator.models.BoxinatorUser;
import com.project.boxinator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<BoxinatorUser> getAllUsers() { return userRepository.findAll(); }

    public BoxinatorUser getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public BoxinatorUser addUser(BoxinatorUser boxinatorUser) {
        return userRepository.save(boxinatorUser);
    }

    public BoxinatorUser update(BoxinatorUser boxinatorUser) {
        getUserById(boxinatorUser.getId());
        return userRepository.save(boxinatorUser);
    }
}
