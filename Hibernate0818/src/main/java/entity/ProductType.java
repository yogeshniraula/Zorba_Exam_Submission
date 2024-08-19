package entity;


import jakarta.persistence.*;

@Entity(name = "product_type")
public class ProductType {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "type", length = 255)
    private String type;

    @Column(name = "rate", length = 10)
    private Long rate;

}
