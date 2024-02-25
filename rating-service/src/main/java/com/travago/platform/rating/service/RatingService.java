package com.travago.platform.rating.service;

import com.travago.platform.rating.entity.HotelRating;
import java.util.List;

public interface RatingService {
    HotelRating create(HotelRating hotelRating);

    List<HotelRating> getRatings();

    List<HotelRating> getRatingByUserId(String userId);

    List<HotelRating> getRatingByHotelId(String hotelId);
}
