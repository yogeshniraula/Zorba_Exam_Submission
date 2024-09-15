package org.springMVC.dao;

import org.springMVC.entity.InventoryCategory;

import java.util.Optional;

public interface InventoryCategoryDAO {
    Optional<InventoryCategory> findCategoryByName(String categoryName);
    String saveCategory(Optional<InventoryCategory> category);


}