package org.springMVC.dao;

import org.springMVC.entity.Inventory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface InventoryDAO {
    String saveInventory(Inventory inventory);


    Inventory getInventoryById(int inventoryId);

    List<Inventory> getAllInventory();
}
