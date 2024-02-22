package com.travago.platform.hotel.repository;

import com.travago.platform.hotel.entity.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String> {
}
