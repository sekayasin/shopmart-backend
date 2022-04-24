package edu.miu.shopmartbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private boolean isApproved;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;
}
