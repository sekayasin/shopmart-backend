package edu.miu.shopmartbackend.model.users;

import edu.miu.shopmartbackend.model.Orders;
import edu.miu.shopmartbackend.model.Review;
import edu.miu.shopmartbackend.model.ShoppingCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Buyer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany
    private List<Orders>orders;
    @OneToMany
    private List<Review>reviews;
    //add product to cart
    @OneToOne
    private ShoppingCart shoppingCart;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Seller> following;

}
