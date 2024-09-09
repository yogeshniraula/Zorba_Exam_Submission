package org.springMVC.dao;

import org.springMVC.entity.User;

import java.util.List;

public interface UserDAO {
    String saveUser(User user);
    User getUserById(Integer userId);
    List<User> getAllUsers();
}
