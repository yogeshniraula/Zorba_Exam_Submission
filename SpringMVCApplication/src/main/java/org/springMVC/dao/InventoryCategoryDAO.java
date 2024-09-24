package org.springMVC.dao;

import org.springMVC.entity.InventoryCategory;
import org.springMVC.model.InventoryCategoryModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface InventoryCategoryDAO {
    Optional<InventoryCategory> findCategoryByName(String categoryName);
    String saveCategory(Optional<InventoryCategory> category);


}