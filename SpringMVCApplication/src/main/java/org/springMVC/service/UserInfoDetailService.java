//package org.springMVC.service;
//
//import org.springMVC.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springMVC.dao.UserDAO;
//import org.springMVC.model.UserModel;
//import org.springMVC.security.UserInfoDetails;
//
//@Service
//public class UserInfoDetailService implements UserDetailsService {
//
//    @Autowired
//    UserDAO userDAO;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userDAO.findByUsername(username);
//        User userDetails = new UserInfoDetails(user);
//
//        return userDetails;
//    }
//}