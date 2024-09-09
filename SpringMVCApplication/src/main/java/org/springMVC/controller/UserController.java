package org.springMVC.controller;


import org.springMVC.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springMVC.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    //http://localhost:8080/context_path/user/test
//    public ModelAndView test() {
//        ModelAndView modelAndView = new ModelAndView("userForm");
//        return modelAndView;
//    }
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/userForm")
    public ModelAndView userForm() {
        ModelAndView modelAndView = new ModelAndView("userForm");
        return modelAndView;
    }


    @PostMapping("/conf")
    public String saveUser(@ModelAttribute UserModel userModel, Model model) {
        String response = userService.saveUserData(userModel);
        model.addAttribute("message", response);
        return "success";//name of the jsp
    }
//    @PostMapping("/success")
//    public ModelAndView second(){
//        ModelAndView mV2= new ModelAndView("success");
//        return mV2;
//
//    }

}

