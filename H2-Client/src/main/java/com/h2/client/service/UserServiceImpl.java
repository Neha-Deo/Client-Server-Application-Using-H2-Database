package com.h2.client.service;

import com.h2.client.entity.User;
import com.h2.client.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<User> fetchAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(User user) {

        User newUser = userRepo.findById(user.getId()).orElse(null);

            newUser.setName(user.getName());
            newUser.setAge(user.getAge());
            newUser.setCity(user.getCity());
            newUser.setEmail(user.getEmail());
            return userRepo.save(newUser);
    }

    @Override
    public String deleteUser(int id) {
        userRepo.deleteById(id);
        return "User deleted with id: " + id;
    }
}