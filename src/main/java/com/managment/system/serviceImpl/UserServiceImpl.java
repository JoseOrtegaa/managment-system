package com.managment.system.serviceImpl;

import com.managment.system.entity.User;
import com.managment.system.repository.UserRepository;
import com.managment.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;


    @Override
    public User createUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public User editUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public User findUser(int id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Boolean existUser(int id) {
        return this.repository.existsById(id);
    }

    @Override
    public void deleteUser(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) this.repository.findAll();
    }

    @Override
    public List<User> findNameUsers(String name) {
        return this.repository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Long countUsers() {
        return this.repository.count();
    }
}
