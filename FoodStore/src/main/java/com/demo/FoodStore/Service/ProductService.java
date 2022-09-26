package com.demo.FoodStore.Service;

import com.demo.FoodStore.Entity.Product;
import com.demo.FoodStore.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll(String search);

    ProductDTO getById(Long id);

    Product save(ProductDTO dto);

    Object update(Long id, ProductDTO dto);

    void delete(Long id);
}
