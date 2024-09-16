package org.springMVC.controller;

import org.springMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/adminLogin")
    public String showLoginPage() {
        return "adminLogin";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            Model model) {

        if (userService.validateUser(email, password, role).isPresent()) {
            // Redirect to add inventory page on successful login
            return "redirect:/adminDashboard";
        } else {
            // Redirect to error page if login fails
            model.addAttribute("errorMessage", "Invalid email, password, or role.");
            return "login";
        }
    }

    @GetMapping("/adminDashboard")
    public String showDashboard(Model model) {
        // Fetch vendors and customers by role
        Optional<Object> vendorList = userService.findByRole("Vendor");
        Optional<Object> customerList = userService.findByRole("Customer");

        // Add the lists to the model
        model.addAttribute("vendorList", vendorList);
        model.addAttribute("customerList", customerList);

        return "adminDashboard";  // Return the dashboard JSP view
    }

    @PostMapping("/deleteUser/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        userService.deleteByUserId(id);
        return "redirect:/adminDashboard";
    }

}
