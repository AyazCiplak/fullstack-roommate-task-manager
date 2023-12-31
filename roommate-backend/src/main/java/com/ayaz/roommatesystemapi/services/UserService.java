package com.ayaz.roommatesystemapi.services;

import com.ayaz.roommatesystemapi.model.User;
import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    boolean deleteUser(Long id);
}
