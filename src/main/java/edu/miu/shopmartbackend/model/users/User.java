package edu.miu.shopmartbackend.model.users;

import edu.miu.shopmartbackend.model.Address;
import edu.miu.shopmartbackend.model.Role;
import edu.miu.shopmartbackend.model.ShoppingCart;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String fName;
    private String lName;
    private String userName;
    private String password;
    private int points;
    @OneToOne
    private Address address;
    @OneToOne
    private ShoppingCart shoppingCart;
    @OneToMany
    List<Role> roles;




}