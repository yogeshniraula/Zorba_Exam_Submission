package org.springMVC.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
public class InventoryModel {

    private int id;
    private String category;
    private String name;
    private int quantity;
    private double price;
    private String imageUrl;
    private String description;
    private Long categoryId;


    //private InventoryCategoryModel category;
    //.getCategoryName();

}
//    public InventoryModel(){
//    };
//
//    public InventoryModel(int id, String name, int quantity, Double price, String imageUrl, String description, InventoryCategoryModel category) {
//        this.id = id;
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//        this.imageUrl = imageUrl;
//        this.description = description;
//        this.category = category;
//    }
//}