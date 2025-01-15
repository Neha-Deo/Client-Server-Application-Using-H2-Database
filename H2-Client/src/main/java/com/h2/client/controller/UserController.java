package com.h2.client.controller;

import com.h2.client.entity.User;
import com.h2.client.service.UserService;
import com.h2.client.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/findUserById/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @GetMapping("/fetchAllUsers")
    public List<User> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

    @PutMapping("/updateUserById")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
