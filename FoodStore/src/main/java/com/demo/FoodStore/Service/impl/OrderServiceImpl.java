package com.demo.FoodStore.Service.impl;

import com.demo.FoodStore.Entity.Order;
import com.demo.FoodStore.Entity.Product;
import com.demo.FoodStore.Repository.OrderRepository;
import com.demo.FoodStore.Service.OrderService;
import com.demo.FoodStore.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<OrderDto> getAll(String search) {
        return search == null || search.isEmpty() ? orderRepository.findAll().stream()
                .sorted(Comparator.comparing(Order::getDate))
                .map(OrderDto::new)
                .collect(Collectors.toList()) :
                orderRepository.findAll().stream()
                        .filter(e -> e.getDate().equals(convertToDate(search)))//buscar por fecha
                        .sorted(Comparator.comparing(Order::getDate)) //ordenar por fecha
                        .map(OrderDto::new)
                        .collect(Collectors.toList());
    }

    @Override
    public Order getById(Long id) {

        return null;
    }

    @Override
    public Order save(OrderDto dto) {

        Order order = new Order(dto);
        order.setTotalAmount(getTotalAmount(dto.getProducts()));
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, OrderDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public LocalDate convertToDate(String date){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public Double getTotalAmount(Set<Product> product){
        return product.stream().map(Product::getPrice)
                .mapToDouble(Double::doubleValue).sum();
    }
}
