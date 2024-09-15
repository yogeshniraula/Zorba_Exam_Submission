package org.springMVC.service;

import org.springMVC.dao.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springMVC.entity.User;
import org.springMVC.model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserModel userModel;



//    @Transactional
//    public String saveUserData(UserModel userModel) {
//        String responseMsg = "";
//        if (userModel.getUserName() != null && userModel.getUserEmail() != null) {
//            UserModel userModels = new UserModel();
//            userModels.setUserName(userModel.getUserName());
//            userModels.setUserEmail(userModel.getUserEmail());
//            userModels.setUserPassword(userModel.getUserPassword());
//            userModels.setUserMobile(userModel.getUserMobile());
//            responseMsg = this.userDAO.saveUser(userModels);
//        } else {
//            responseMsg = "Could Not Process";
//        }
//        return responseMsg;
//    }

    public UserModel getUserModelById(Integer userModelId) {
        if (userModelId == null) {
            return new UserModel();
        }
        User userModel = this.userDAO.getUserById(userModelId);
        UserModel userModelModel = new UserModel();
        userModelModel.setUserId(userModel.getUserId());
        userModelModel.setUserName(userModel.getUserName());
        userModelModel.setUserEmail(userModel.getUserEmail());
        return  userModelModel;
    }

    public List<UserModel> getAllUserModels() {
        List<User> userModels = this.userDAO.getAllUsers();
        List<UserModel> userModelModels = new ArrayList<>();
        for (User userModel: userModels) {
            UserModel userModelModel = new UserModel();


            userModelModel.setUserId(userModel.getUserId());
            userModelModel.setUserName(userModel.getUserName());
            userModelModel.setUserEmail(userModel.getUserEmail());
            userModelModel.setUserPassword(userModel.getUserPassword());
            userModelModel.setUserMobile(userModel.getUserMobile());
            //userModelModel.setUserModelUserModelname(userModel.getUserModelUserModelname());
            userModelModels.add(userModelModel);
        }
        return userModelModels;
    }

    public Optional<Object> validateUser(String email, String password, String role) {
        return userDAO.findByUsernameAndPassword(email, password, role)
                .filter(userModel -> userModel.equals(email) && userModel.equals(password) && userModel.equals(role));
    }

    @Transactional
    public String saveUserData(UserModel userModel) {
        String responseMsg = "";
        if (userModel.getUserName() != null && userModel.getUserEmail() != null && userModel.getUserPassword() != null
                && userModel.getUserMobile() != null && userModel.getUserRole() != null) {
            //logger.info("Received Student Name : "+studentModel.getStudName());
            User user = new User();
            user.setUserName(userModel.getUserName());
            user.setUserEmail(userModel.getUserEmail());
            user.setUserPassword(userModel.getUserPassword());
            user.setUserMobile(userModel.getUserMobile());
            user.setUserRole(userModel.getUserRole());
            responseMsg = this.userDAO.saveUser(userModel);
        } else {
            responseMsg = "Could Not Process";
        }
        return responseMsg;
    }
}
