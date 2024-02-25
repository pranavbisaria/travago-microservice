package com.travago.platform.rating.repository;

import com.travago.platform.rating.entity.HotelRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HotelRatingRepository extends JpaRepository<HotelRating, String> {
    List<HotelRating> findByHotelId(String hotelId);

    List<HotelRating> findByUserId(String userId);
}
