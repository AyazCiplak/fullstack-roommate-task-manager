package com.ayaz.roommatesystemapi.controller;

import com.ayaz.roommatesystemapi.model.User;
import com.ayaz.roommatesystemapi.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

  @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

  @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

  @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = null;
        user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id) {
        boolean deleted;
        deleted = userService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted successfully", deleted);
        return ResponseEntity.ok(response);
    }



}
