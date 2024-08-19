package entity;

import jakarta.persistence.*;

@Entity(name = "customer")
public class Customer {
    @Column(name = "CustomerId", length = 255)
    private String CustomerId;

    @Column(name = "CustName", length = 255)
    private String CustName;

    @Column(name = "CustEmail", length = 255)
    private String CustEmail;

    @Column(name = "finalProductPrice", length = 255)
    private Float finalProductPrice;


}
