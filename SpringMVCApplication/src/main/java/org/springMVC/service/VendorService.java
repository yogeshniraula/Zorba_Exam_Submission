package org.springMVC.service;

import org.springMVC.dao.InventoryCategoryDAO;
import org.springMVC.dao.InventoryDAO;
import org.springMVC.entity.Inventory;
import org.springMVC.entity.InventoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class VendorService {

    private InventoryCategoryDAO categoryDAO;


    private InventoryDAO inventoryDAO;

    @Autowired
    public VendorService(InventoryDAO inventoryDAO){
        this.inventoryDAO = inventoryDAO;
    }

    @Transactional
    public void addInventory(int id, String categoryName, String name, int quantity, Double price, String imageUrl, String description) {
        // Find or create the InventoryCategory entity
        InventoryCategory category = categoryDAO.findCategoryByName(categoryName)
                .orElseGet(() -> {
                    InventoryCategory newCategory = new InventoryCategory();
                    categoryDAO.saveCategory(Optional.of(newCategory));
                    return newCategory;
                });

        // Create the Inventory entity
        Inventory inventory = new Inventory(id);

        // Save the Inventory entity to the database
        inventoryDAO.saveInventory(inventory);
    }
}
