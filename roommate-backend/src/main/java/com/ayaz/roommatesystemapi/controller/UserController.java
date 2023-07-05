package com.ayaz.roommatesystemapi.controller;

import com.ayaz.roommatesystemapi.model.User;
import com.ayaz.roommatesystemapi.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserService userService;

    public UserController(UserService roommateService) {
        this.userService = roommateService;
    }

  @PostMapping("/users")
    public User createRoommate(@RequestBody User roommate) {
        return userService.createRoommate(roommate);
    }

  @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
