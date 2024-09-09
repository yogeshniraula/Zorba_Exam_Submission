package org.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springmvc.entity.User;
import org.springmvc.model.UserModel;
import org.springmvc.service.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping(path = "/userForm")  //http://localhost:8080/context_path/user/test
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView("userForm");
        return modelAndView;
    }

    @PostMapping("/validate")
    public String validateEmail(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "success";
        }
        model.addAttribute("email", user.getUserEmail());
        return "success";
    }

//    @GetMapping("/first")
//    public ModelAndView first() {
//        ModelAndView modelAndView = new ModelAndView("first");
//        modelAndView.addObject("responseTxt", "First Spring MVC application...");
//        return modelAndView;
//    }
//
//    @PostMapping("/saveUserData")
//    public String saveUser(@ModelAttribute UserModel userModel, Model model) {
//        String response = userService.saveUserData(userModel);
//        model.addAttribute("message", response);
//        return "success";
//    }
//
//    @GetMapping("/getAllUserData")
//    public String getAllUser(Model model) {
//        List<UserModel> userModels = this.userService.getAllUsers();
//        model.addAttribute("allUserInfo",userModels);
//        return "userDashboard";
//    }
//
//
//    @GetMapping("/getUserById/{id}")
//    public ModelAndView getUserById(@PathVariable("id") Integer userId) {
//        Integer uId = userId;
//        ModelAndView modelAndView = new ModelAndView("viewUser");
//        UserModel userModel = this.userService.getUserById(userId);
//        modelAndView.addObject("userObj", userModel);
//        return modelAndView;
//    }
//
//    @PutMapping("/updateUserData")
//    public ModelAndView updateUser(@RequestParam(name = "userName") String userName,
//                                      @RequestParam(name = "userEmail") String userEmail,
//                                   @RequestParam (name = "userUsername") String userUsername,
//                                   @RequestParam(name = "userPassword") String userPassword,
//                                   @RequestParam(name = "userMobile") String userMobile ) {
//
//        String response = null;
//        ModelAndView modelAndView = new ModelAndView("updateUser");
//        modelAndView.addObject("response", response);
//        return modelAndView;
//    }
//
//    @DeleteMapping("/deleteUser/{name}")
//    public ModelAndView deleteUserById(@PathVariable("name") String userName) {
//        ModelAndView modelAndView = new ModelAndView("userDashboard");
//        return modelAndView;
//    }
}