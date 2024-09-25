package org.springMVC.service;

import org.springMVC.dao.InventoryCategoryDAO;
import org.springMVC.dao.InventoryDAO;
import org.springMVC.entity.Inventory;
import org.springMVC.entity.InventoryCategory;
import org.springMVC.exception.CustomDataIntegrityViolationException;
import org.springMVC.model.InventoryCategoryModel;
import org.springMVC.model.InventoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private InventoryDAO inventoryDAO;

    private InventoryCategoryDAO inventoryCategoryDAO;

    private InventoryCategoryModel inventoryCategory;

    private  InventoryModel inventoryModel;

    public InventoryService(InventoryDAO inventoryDAO){
        this.inventoryDAO = inventoryDAO;
    }


    public void saveInventory(InventoryModel inventory) {

    }
    public String processCategory(String categoryName) {
        Optional<InventoryCategory> category1 = inventoryCategoryDAO.findCategoryByName(categoryName);

        if (category1 == null) {
            InventoryCategoryModel category2 = new InventoryCategoryModel();
            category2.setCategoryName(categoryName);
            categoryName = inventoryCategoryDAO.saveCategory(category1);
        }
        return categoryName;
    }



    public List<InventoryModel> getAllInventory() throws CustomDataIntegrityViolationException {
        List<Inventory> inventoryM = this.inventoryDAO.getAllInventory();
        List<InventoryModel> inventoryModels = new ArrayList<>();

        for (Inventory inventory : inventoryM) {
            InventoryModel inventoryModel = new InventoryModel();

            // Set values from Inventory to InventoryModel
            inventoryModel.setId(inventory.getId());  // Corrected: use inventory.getId()
            inventoryModel.setName(inventory.getName());
            inventoryModel.setQuantity(inventory.getQuantity());
            inventoryModel.setPrice(inventory.getPrice());
            inventoryModel.setDescription(inventory.getDescription());

            // Add to the list
            inventoryModels.add(inventoryModel);
        }

        return inventoryModels;
    }

}
