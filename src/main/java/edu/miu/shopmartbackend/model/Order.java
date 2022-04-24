package edu.miu.shopmartbackend.model;

import edu.miu.shopmartbackend.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(style = "yyyy-mm-dd")
    private LocalDate orderDate;
    private OrderStatus orderStatus;
    private double totalOrderPrice;

    @ManyToOne
    private User user;

    @OneToMany
    private List<Product> products;
}