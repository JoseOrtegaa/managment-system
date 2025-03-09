package com.managment.system.service;

import com.managment.system.entity.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User editUser(User user);
    public User findUser(int id);
    public Boolean existUser(int id);
    public void deleteUser(int id);
    public List<User> findAllUsers();
    public List<User> findNameUsers(String condition);
    public Long countUsers();
}
