package org.springMVC.dao;

import org.springMVC.entity.User;
import org.springMVC.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface UserDAO {
    String saveUser(UserModel user);
    User getUserById(Integer userId);
    List<User> getAllUsers();
    Optional<Object> findByUsernameAndPassword(String email, String password, String role);
    Optional<Object> findByRole(String role);
    void deleteUserById(Integer userId);

    User findByUsername(String username);
}
