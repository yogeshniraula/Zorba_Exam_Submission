package org.springMVC.service;

import org.springMVC.dao.InventoryCategoryDAO;
import org.springMVC.dao.InventoryDAO;
import org.springMVC.entity.Inventory;
import org.springMVC.entity.InventoryCategory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class VendorService {

    @Autowired
    private InventoryCategoryDAO categoryDAO;

    @Autowired
    private InventoryDAO inventoryDAO;

    @Transactional
    public void addInventory(String categoryName, String name, int quantity, double price, String imageUrl, String description) {
        InventoryCategory category = categoryDAO.findByCategoryName(categoryName).orElseGet(() -> {
            InventoryCategory newCategory = new InventoryCategory(categoryName);
            categoryDAO.saveCategory(newCategory);
            return newCategory;
        });

        Inventory inventory = new Inventory(name, quantity, price, imageUrl, description, category);
        inventoryDAO.saveInventory(inventory);
    }
}
