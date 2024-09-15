package org.springMVC.dao;

import org.springMVC.entity.User;
import org.springMVC.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    String saveUser(UserModel user);
    User getUserById(Integer userId);
    List<User> getAllUsers();
    Optional<Object> findByUsernameAndPassword(String email, String password, String role);
}
