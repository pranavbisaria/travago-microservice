package com.travago.platform.user.service.impl;

import com.travago.platform.user.entity.Hotel;
import com.travago.platform.user.entity.User;
import com.travago.platform.user.entity.UserRating;
import com.travago.platform.user.exception.ResourceNotFoundException;
import com.travago.platform.user.repository.UserRepository;
import com.travago.platform.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

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
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));

        UserRating[] userRatings = restTemplate.getForObject("http://localhost:8093/api/v1/ratings/users/"+ user.getId(), UserRating[].class);
        assert userRatings != null;

        List<UserRating> ratings = Arrays.stream(userRatings).collect(Collectors.toList());

        List<UserRating> userRatingResponse = ratings.stream().map(rating -> {
            ResponseEntity<Hotel> hotelResponse = restTemplate.getForEntity("http://localhost:8092/api/v1/hotels/"+ rating.getHotelId(), Hotel.class);

            if (hotelResponse.getStatusCode() == HttpStatus.OK)
                rating.setHotel(hotelResponse.getBody());

            return rating;
        }).collect(Collectors.toList());

        user.setRatings(userRatingResponse);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        this.userRepository.deleteById(id);
    }
}
