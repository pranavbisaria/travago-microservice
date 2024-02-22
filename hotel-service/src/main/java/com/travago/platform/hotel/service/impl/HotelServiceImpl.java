package com.travago.platform.hotel.service.impl;

import com.travago.platform.hotel.entity.Hotel;
import com.travago.platform.hotel.exception.ResourceNotFoundException;
import com.travago.platform.hotel.repository.HotelRepository;
import com.travago.platform.hotel.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return this.hotelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Hotel not found with id " + id)
        );
    }
}
