package com.travago.platform.user.service.impl;

import com.travago.platform.user.entity.User;
import com.travago.platform.user.repository.UserRepository;
import com.travago.platform.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User oldUser = this.userRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + user.getId()));

        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setAbout(user.getAbout());
        return this.userRepository.save(oldUser);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUser(String id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }
}
