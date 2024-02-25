package com.travago.platform.rating.service.impl;

import com.travago.platform.rating.entity.HotelRating;
import com.travago.platform.rating.repository.HotelRatingRepository;
import com.travago.platform.rating.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final HotelRatingRepository hotelRatingRepository;

    @Override
    public HotelRating create(HotelRating hotelRating) {
        hotelRating.setId(java.util.UUID.randomUUID().toString());
        return this.hotelRatingRepository.save(hotelRating);
    }

    @Override
    public List<HotelRating> getRatings() {
        return this.hotelRatingRepository.findAll();
    }

    @Override
    public List<HotelRating> getRatingByUserId(String userId) {
        return this.hotelRatingRepository.findByUserId(userId);
    }

    @Override
    public List<HotelRating> getRatingByHotelId(String hotelId) {
        return this.hotelRatingRepository.findByHotelId(hotelId);
    }
}
