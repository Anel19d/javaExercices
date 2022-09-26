package com.demo.FoodStore.Service.impl;

import com.demo.FoodStore.Entity.Category;
import com.demo.FoodStore.Entity.Order;
import com.demo.FoodStore.Entity.Product;
import com.demo.FoodStore.Repository.ProductRepository;
import com.demo.FoodStore.Service.ProductService;
import com.demo.FoodStore.dto.CategoryDTO;
import com.demo.FoodStore.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    //filtrar por nombre

    @Override
    public List<ProductDTO> getAll(String search) {

        return  search == null || search.isEmpty() ? productRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Product::getPrice))//ordenar por precio
                .map(ProductDTO::new)
                .collect(Collectors.toList()) :
                productRepository.findAll()
                        .stream()
                        .filter(n -> n.getName().equals(search))
                        .sorted(Comparator.comparing(Product::getPrice))//ordenar por precio
                        .map(ProductDTO::new)
                        .collect(Collectors.toList());
        //.sort(Comparator.comparing(ProductDTO::getPrice));

    }

    @Override
    public ProductDTO getById(Long id) {
        ProductDTO categoryDTO = new ProductDTO();
        Optional<Product> productOptional = findById(Integer.parseInt(id.toString()));
        if (productOptional.isPresent()) {
            categoryDTO = new ProductDTO(productOptional.get());
        }
        return categoryDTO;
    }

    @Override
    public Product save(ProductDTO dto) {
        Product category = new Product(dto);
        return productRepository.save(category);
    }

    @Override
    public Object update(Long id, ProductDTO dto) {
        Product product = null;
        Optional<Product> productOptional = findById(Integer.parseInt(id.toString()));
        if (productOptional.isPresent()) {
            product = productOptional.get();
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product = productRepository.save(product);
        }

        return product;
    }

    @Override
    public void delete(Long id) {
        Optional<Product> productOptional = findById(Integer.parseInt(id.toString()));
        if (productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
        }
    }

    public Optional<Product> findById(Integer id) {
        Optional<Product> productOptional = Optional
                .ofNullable(productRepository.findById(id))
                .orElseThrow(() -> new IllegalStateException(
                        "The id is not exist"));
        return productOptional;
    }
}
