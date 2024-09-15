package org.springMVC.entity;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "inventory_name", nullable = false)
    private String name;

    @Column(name = "inventory_quantity", nullable = false)
    private Double quantity;

    @Column(name = "inventory_price", nullable = false)
    private double price;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "inventory_description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private InventoryCategory category;

    // Constructors, getters, and setters
    public Inventory() {}

    public Inventory(String name, int quantity, double price, String imageUrl, String description, InventoryCategory category) {
        this.name = name;
        this.quantity = (double) quantity;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InventoryCategory getCategory() {
        return category;
    }

    public void setCategory(InventoryCategory category) {
        this.category = category;
    }
}
