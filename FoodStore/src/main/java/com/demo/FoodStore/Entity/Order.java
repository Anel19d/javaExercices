package com.demo.FoodStore.Entity;

import com.demo.FoodStore.dto.OrderDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="order_tbl")
@Getter
@Setter
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_date", nullable = false)
    private Date date;

    @Column(name = "total_amount")
    private Double totalAmount;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
    @JoinTable(
            name = "order_product",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "order_id") }
    )
    private Set<Product> products;

    public Order(OrderDto dto) {
        this.date = dto.getDate();
    }

    public Order() {
    }
}
