package org.springmvc.dao;
import java.util.List;
import org.springmvc.entity.User;

    public interface UserDAO {

        String saveUser(User user);
        User getUserById(Integer userId);
        List<User> getAllUsers();


    }

