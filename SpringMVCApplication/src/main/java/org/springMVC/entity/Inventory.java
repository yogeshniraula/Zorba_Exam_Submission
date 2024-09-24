package org.springMVC.entity;

import lombok.Data;
import org.springMVC.model.InventoryCategoryModel;

import javax.persistence.*;

@Entity
@Data
@Table(name = "inventory")
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "inventory_name", nullable = false)
    private String name;

    @Column(name = "inventory_quantity", nullable = false)
    private int quantity;

    @Column(name = "inventory_price", nullable = false)
    private double price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "inventory_description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private InventoryCategory category;

    public Inventory(int id) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.category = category;
    }
}
