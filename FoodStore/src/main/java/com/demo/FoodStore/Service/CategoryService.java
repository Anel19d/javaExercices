package com.demo.FoodStore.Service;

import com.demo.FoodStore.Entity.Category;
import com.demo.FoodStore.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories(String search);

    CategoryDTO getById(Long id);

    Category save(CategoryDTO categoryDTO);

    Category update(Long id, CategoryDTO categoryDT);

    void delete(Long id);

}
