package org.springMVC.dao;

import org.springMVC.entity.InventoryCategory;

import java.util.Optional;

public interface InventoryCategoryDAO {
    Optional<InventoryCategory> findByCategoryName(String categoryName);
    void saveCategory(InventoryCategory category);
}