package edu.miu.shopmartbackend.model;

import edu.miu.shopmartbackend.enums.OrderStatus;
import edu.miu.shopmartbackend.model.users.Buyer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private double totalOrderPrice;

    @ManyToOne
    private Buyer buyer;

    @OneToMany
    private List<Product> products;
}