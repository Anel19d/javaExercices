package com.demo.FoodStore.dto;

import com.demo.FoodStore.Entity.Order;
import com.demo.FoodStore.Entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class OrderDto {

    private Date date;
    private Double totalAmount;
    @JsonManagedReference
    private Set<ProductDTO> products;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.date = order.getDate();
        this.totalAmount = order.getTotalAmount();
        Set<ProductDTO> products = order.getProducts().stream()
                .map(ProductDTO::new).collect(Collectors.toSet());
        this.products = products;
    }
}
