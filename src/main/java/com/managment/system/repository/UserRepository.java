package com.managment.system.repository;

import com.managment.system.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByNameContainingIgnoreCase(String name);
}
