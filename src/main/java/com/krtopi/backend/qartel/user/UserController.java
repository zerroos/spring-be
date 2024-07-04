package com.krtopi.backend.qartel.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    // GET /api/user/settings/{id}
    @GetMapping("/api/user/settings/{id}")
    public UserEntity getUserSettingsById(@PathVariable String id) {
        return userService.getUserSettingsById(id);
    }

    // GET /api/user/{id}
    @GetMapping("/api/user/{id}")
    public UserEntity getUserById(@PathVariable String id) {
        return userService.getUserSettingsById(id);
    }
}
