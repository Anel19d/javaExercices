package com.demo.FoodStore.Service;

import com.demo.FoodStore.Entity.Order;
import com.demo.FoodStore.dto.CategoryDTO;
import com.demo.FoodStore.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAll(String search);

    Order getById(Long id);

    Order save(OrderDto dto);

    Order update(Long id, OrderDto dto);

    void delete(Long id);
}
