package com.travago.platform.user.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {
    private String id;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
}
