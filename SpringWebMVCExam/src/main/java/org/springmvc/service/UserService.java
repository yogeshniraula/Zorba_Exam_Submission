package org.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springmvc.dao.UserDAO;
import org.springmvc.entity.User;
import org.springmvc.model.UserModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public String saveUserData(UserModel userModel) {
        String responseMsg = "";
        if (userModel.getUserName() != null && userModel.getUserEmail() != null) {
            User user = new User();
            user.setUserName(userModel.getUserName());
            user.setUserEmail(userModel.getUserEmail());
            user.setUserPassword(userModel.getUserPassword());
            user.setUserMobile(userModel.getUserMobile());
            user.setUserUsername(userModel.getUserUsername());
            responseMsg = this.userDAO.saveUser(user);
        } else {
            responseMsg = "Could Not Process";
        }
        return responseMsg;
    }

    public UserModel getUserById(Integer userId) {
        if (userId == null) {
            return new UserModel();
        }
        User user = this.userDAO.getUserById(userId);
        UserModel userModel = new UserModel();
        userModel.setUserId(user.getUserId());
        userModel.setUserName(user.getUserName());
        userModel.setUserEmail(user.getUserEmail());
        return  userModel;
    }

    public List<UserModel> getAllUsers() {
        List<User> users = this.userDAO.getAllUser();
        List<UserModel> userModels = new ArrayList<>();
        for (User user: users) {
            UserModel userModel = new UserModel();


            userModel.setUserId(user.getUserId());
            userModel.setUserName(user.getUserName());
            userModel.setUserEmail(user.getUserEmail());
            userModel.setUserPassword(user.getUserPassword());
            userModel.setUserMobile(user.getUserMobile());
            userModel.setUserUsername(user.getUserUsername());
            userModels.add(userModel);
        }
        return userModels;
    }
}