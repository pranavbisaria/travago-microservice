package com.travago.platform.user.service;

import com.travago.platform.user.entity.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    User updateUser(User user);

    List<User> getAllUser();

    User getUser(String Id);

    void deleteUser(String id);
}
