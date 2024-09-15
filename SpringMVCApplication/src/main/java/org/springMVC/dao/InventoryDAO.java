package org.springMVC.dao;

import org.springMVC.entity.Inventory;

import java.util.List;

public interface InventoryDAO {
    String saveInventory(Inventory inventory);


    Inventory getInventoryById(Integer inventoryId);

    List<Inventory> getAllInventory();
}
