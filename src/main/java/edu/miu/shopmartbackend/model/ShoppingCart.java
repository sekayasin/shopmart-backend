package edu.miu.shopmartbackend.model;

import edu.miu.shopmartbackend.model.users.Buyer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    @OneToOne
    private Buyer buyer;

    @OneToMany
    private List<Product> products;


}
