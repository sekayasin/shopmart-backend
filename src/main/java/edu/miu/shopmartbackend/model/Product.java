package edu.miu.shopmartbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private double price;
    private String description;
    private boolean isPurchased;

    //seller
    @ManyToOne
    private User seller;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
