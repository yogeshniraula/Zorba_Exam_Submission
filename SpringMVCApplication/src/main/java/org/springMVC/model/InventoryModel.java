package org.springMVC.model;

import lombok.*;

@Data

public class InventoryModel {
    private Long id;
    private String name;
    private int quantity;
    private double price;
    private String imageUrl;
    private String description;
    private Long categoryId; // Changed to Long to match the InventoryCategory's ID
}