package edu.miu.shopmartbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private int points;
    private boolean isAproved;
    private boolean isFollowing;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "ship_street")),
            @AttributeOverride(name = "city", column = @Column(name = "ship_city")),
            @AttributeOverride(name = "state", column = @Column(name = "ship_state")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "ship_zipcode"))
    })
    private Address shippingAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "bill_street")),
            @AttributeOverride(name = "city", column = @Column(name = "bill_city")),
            @AttributeOverride(name = "state", column = @Column(name = "bill_state")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "bill_zipcode"))
    })
    private Address billingAddress;

    @OneToOne(mappedBy = "buyer")
    private ShoppingCart shoppingCart;

    @ManyToMany
    List<Role> roles;

    @OneToMany
    private List<Orders> orders;

    @OneToMany
    private List<Review> reviews;

    @OneToMany
    private List<Product> products;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Follow> followers;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<Follow> followings;
}