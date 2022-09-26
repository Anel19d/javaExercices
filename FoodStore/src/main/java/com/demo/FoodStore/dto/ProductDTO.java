package com.demo.FoodStore.dto;

import com.demo.FoodStore.Entity.Category;
import com.demo.FoodStore.Entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private String name;
    private String description;

    private CategoryDTO category;

    private Double price;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        Category cat = new Category();
        cat.setId(product.getCategory().getId());
        cat.setName(product.getCategory().getName());
        this.category = new CategoryDTO(cat);
        this.price = product.getPrice();
    }
}
