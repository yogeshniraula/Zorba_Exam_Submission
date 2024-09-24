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

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private InventoryDAO inventoryDAO;
    @Autowired
    private InventoryCategoryDAO inventoryCategoryDAO;
    @Autowired
    private InventoryCategoryModel inventoryCategory;
    @Autowired
    private  InventoryModel inventoryModel;


    public void saveInventory(InventoryModel inventory) {

    }
    public InventoryCategoryModel processCategory(String categoryName) {
        Optional<InventoryCategory> category1 = inventoryCategoryDAO.findCategoryByName(categoryName);

        if (category1 == null) {
            InventoryCategoryModel category2 = new InventoryCategoryModel(categoryName);
            category2.setCategoryName(categoryName);
            categoryName = inventoryCategoryDAO.saveCategory(category1);
        }
        return new InventoryCategoryModel(categoryName);
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
