package org.springMVC.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Component
public class InventoryModel {
    private Long id;
    private String name;
    private Double quantity;
    private double price;
    private String imageUrl;
    private String description;
    private Long categoryId; // Changed to Long to match the InventoryCategory's ID
}