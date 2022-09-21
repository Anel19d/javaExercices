package com.demo.FoodStore.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="order")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private Date date;

    @Column(name = "total_amount")
    private Double totalAmount;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "order_product",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private Set<Product> product;
}
