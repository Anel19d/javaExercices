package com.demo.FoodStore.Entity;

import com.demo.FoodStore.dto.OrderDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

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



    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="order_product", joinColumns={@JoinColumn(name="product_id")},
            inverseJoinColumns={@JoinColumn(name="order_id")})
    private Set<Product> products=new HashSet();

    public Order(OrderDto dto) {
        this.date = dto.getDate();
    }

    public Order() {
    }
}
