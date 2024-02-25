package com.travago.platform.rating.controller;

import com.travago.platform.rating.entity.HotelRating;
import com.travago.platform.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/ratings")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<HotelRating> create(@RequestBody HotelRating hotelRating) {
        return new ResponseEntity(this.ratingService.create(hotelRating), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<HotelRating>> getAll() {
        return ResponseEntity.ok(this.ratingService.getRatings());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<HotelRating>> getByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(this.ratingService.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<HotelRating>> getByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(this.ratingService.getRatingByHotelId(hotelId));
    }
}
