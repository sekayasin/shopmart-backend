package edu.miu.waa.finalproject.model.users;

import edu.miu.waa.finalproject.model.Address;
import edu.miu.waa.finalproject.model.Role;
import edu.miu.waa.finalproject.model.ShoppingCart;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
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
