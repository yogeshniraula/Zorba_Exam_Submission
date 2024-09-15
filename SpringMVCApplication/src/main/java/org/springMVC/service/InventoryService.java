package org.springMVC.service;

import org.springMVC.dao.InventoryCategoryDAO;
import org.springMVC.dao.InventoryDAO;
import org.springMVC.entity.Inventory;
import org.springMVC.exception.CustomDataIntegrityViolationException;
import org.springMVC.model.InventoryModel;
import org.springMVC.entity.InventoryCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    private InventoryDAO inventoryDAO;
    private InventoryCategoryDAO inventoryCategoryDAO;
    private InventoryCategory inventoryCategory;


    public void saveInventory(Inventory inventory) {

    }
    public InventoryCategory processCategory(String category) {
        Optional<InventoryCategory> category1 = inventoryCategoryDAO.findCategoryByName(category);

        if (category == null) {
            InventoryCategory category2 = new InventoryCategory();
            category2.setCategoryName(category);
            category = inventoryCategoryDAO.saveCategory(category1);
        }
        return new InventoryCategory(category);
    }



    public List<InventoryModel> getAllInventory() throws CustomDataIntegrityViolationException {
        List<Inventory> inventoryM = this.inventoryDAO.getAllInventory();
        List<InventoryModel> inventoryModels = new ArrayList<>();
        for (Inventory inventory: inventoryM) {
            InventoryModel inventoryModel = new InventoryModel();
            inventoryModel.setId(inventoryModel.getId());
            inventoryModel.setName(inventoryModel.getName());
            inventoryModel.setQuantity(inventoryModel.getQuantity());
            inventoryModel.setPrice(inventoryModel.getPrice());
            inventoryModel.setDescription(inventoryModel.getDescription());

            inventoryModels.add(inventoryModel);
        }
        return inventoryModels;
    }
}
