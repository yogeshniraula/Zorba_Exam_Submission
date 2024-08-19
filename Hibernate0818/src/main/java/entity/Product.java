package entity;

import jakarta.persistence.*;

@Entity(name = "Product")
public class Product {

    @Column(name = "ProductId", length = 255)
    private String ProductId;


    @Column(name = "ProductName", length = 255)
    private String ProductName;

    @Column(name = "productQuantity", length = 255)
    private Float productQuantity;

    @ManyToMany
    @JoinColumn(name = "CustId", referencedColumnName = "CustomerId")
    private Customer CustomerId;

    @ManyToOne
    @JoinColumn(name = "prod_type_id", referencedColumnName = "type")
    private ProductType productType;
}

