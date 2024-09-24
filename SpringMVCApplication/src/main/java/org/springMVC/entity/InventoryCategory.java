package org.springMVC.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "inventory_category")
public class InventoryCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", unique = true, nullable = false)
    private String categoryName;

}
