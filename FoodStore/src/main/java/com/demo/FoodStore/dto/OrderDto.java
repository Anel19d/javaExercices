package com.demo.FoodStore.dto;

import com.demo.FoodStore.Entity.Order;
import com.demo.FoodStore.Entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OrderDto {

    private Date date;
    private Double totalAmount;
    private Set<Product> products;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.date = order.getDate();
        this.totalAmount = order.getTotalAmount();
        this.products = order.getProducts();
    }
}
