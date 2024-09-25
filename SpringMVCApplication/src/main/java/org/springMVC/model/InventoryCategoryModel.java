package org.springMVC.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Component
public class InventoryCategoryModel {
    private Long id;
    private String categoryName;


}