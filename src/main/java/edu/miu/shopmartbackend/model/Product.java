package edu.miu.shopmartbackend.model;

import edu.miu.shopmartbackend.model.users.Seller;
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
    private long productId;
    private String productName;
    private double price;
    private String description;
    private boolean isPurchased;
    @OneToMany
    private List<Review> reviews;
    @ManyToOne
    private Seller sellers;

}
