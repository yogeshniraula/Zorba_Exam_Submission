package org.springMVC.controller;

import org.springMVC.entity.Inventory;
import org.springMVC.model.InventoryModel;
import org.springMVC.service.UserService;
import org.springMVC.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class VendorController {

    // This is a hardcoded example; in real-world, fetch from the database
    @Autowired
    private UserService userService;
    @Autowired
    private VendorService vendorService;
    @Autowired
    InventoryModel inventory;

    @GetMapping("/vendorLogin")
    public String showLoginPage() {
        return "vendorLogin";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            Model model) {

        if (userService.validateUser(email, password, role).isPresent()) {
            // Redirect to add inventory page on successful login
            return "redirect:/addInventory";
        } else {
            // Redirect to error page if login fails
            model.addAttribute("errorMessage", "Invalid email, password, or role.");
            return "vendorLogin";
        }
    }

    @PostMapping("/submitInventory")
    public String submitInventory(
            @RequestParam("category") String category,
            @RequestParam("name") String name,
            @RequestParam("quantity") Integer quantity,
            @RequestParam("price") Double price,
            @RequestParam("image") MultipartFile image,
            @RequestParam("description") String description,
            Model model) {

        // Validation: Check if any field is missing
        if (category == null || category.isEmpty() ||
                name == null || name.isEmpty() ||
                quantity == null || quantity <= 0 ||
                price == null || price <= 0.0 ||
                image.isEmpty() ||
                description == null || description.isEmpty()) {

            // Redirect to error page if validation fails
            model.addAttribute("errorMessage", "Incomplete Inventory Data, please recheck!!");
            return "addInventory";
        }

        vendorService.addInventory(inventory.getId(), inventory.getCategoryName(), inventory.getName(), inventory.getQuantity(),
                inventory.getPrice(), inventory.getImageUrl(), inventory.getDescription());
        model.addAttribute("message", "Inventory added successfully!");
        return "inventorySuccess"; // Redirect to success page
    }
}
