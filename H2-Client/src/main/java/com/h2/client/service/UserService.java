package com.h2.client.service;

import com.h2.client.entity.User;

import java.util.List;

public interface UserService {

    public User addUser(User user);

    public List<User> fetchAllUsers();

    public User findUserById(int id);

    public User updateUser(User user);

    public String deleteUser(int id);
}
