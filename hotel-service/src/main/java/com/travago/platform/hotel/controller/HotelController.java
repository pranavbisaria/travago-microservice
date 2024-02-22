package com.travago.platform.hotel.controller;

import com.travago.platform.hotel.entity.Hotel;
import com.travago.platform.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hotels")
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id) {
        return ResponseEntity.ok(this.hotelService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAll() {
        return ResponseEntity.ok(this.hotelService.getAll());
    }

    @PostMapping
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(this.hotelService.create(hotel));
    }
}
