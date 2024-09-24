package org.springMVC.service;

import org.springMVC.dao.UserDAO;

import org.springMVC.exception.CustomDataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springMVC.entity.User;
import org.springMVC.model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

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

    public UserModel getUserById(Integer userId) {
        if (userId == null) {
            return new UserModel();
        }
        User user = this.userDAO.getUserById(userId);
        UserModel userModels = new UserModel();
        userModels.setUserId(userModel.getUserId());
        userModels.setUserName(userModel.getUserName());
        userModels.setUserEmail(userModel.getUserEmail());
        return  userModels;
    }

    public List<UserModel> getAllUsers()  throws CustomDataIntegrityViolationException {
        List<User> users = this.userDAO.getAllUsers();
        List<UserModel> userModels = new ArrayList<>();
        for (User user: users) {
            UserModel userModel = new UserModel();


            userModel.setUserId(userModel.getUserId());
            userModel.setUserName(userModel.getUserName());
            userModel.setUserEmail(userModel.getUserEmail());
            userModel.setUserPassword(userModel.getUserPassword());
            userModel.setUserMobile(userModel.getUserMobile());
            //userModelModel.setUserModelUserModelname(userModel.getUserModelUserModelname());
            userModels.add(userModel);
        }
        return userModels;
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

    public Optional<Object> findByRole(String role) {
        return userDAO.findByRole(role);
    }

    public void deleteByUserId(int userId) {
        userDAO.deleteUserById(userId);
    }
}
