package com.demo.FoodStore.Service.impl;

import com.demo.FoodStore.Entity.Category;
import com.demo.FoodStore.Repository.CategoryRepository;
import com.demo.FoodStore.Service.CategoryService;
import com.demo.FoodStore.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories(String search) {
        return categoryRepository.findAll().stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getById(Long id) {
        CategoryDTO categoryDTO = new CategoryDTO();
        Optional<Category> categoryDTOOptional = findById(Integer.parseInt(id.toString()));
        if(categoryDTOOptional.isPresent()){
            categoryDTO = new CategoryDTO(categoryDTOOptional.get());
        }
        return categoryDTO;
    }

    @Override
    public Category save(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO);
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, CategoryDTO categoryDTO) {
        Category category = null;
        Optional<Category> categoryOptional = findById(Integer.parseInt(id.toString()));
        if(categoryOptional.isPresent()){
            category = categoryOptional.get();
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            category = categoryRepository.save(category);
        }

        return category;
    }

    @Override
    public void delete(Long id) {

        Optional<Category> categoryOptional = findById(Integer.parseInt(id.toString()));
        if(categoryOptional.isPresent()) {
            categoryRepository.delete(categoryOptional.get());
        }

    }


    public Optional<Category> findById(Integer id){
        Optional<Category> categoryDTOOptional =  Optional
                .ofNullable(categoryRepository.findById(id))
                .orElseThrow(() -> new IllegalStateException(
                        "The id is not exist"));
        return categoryDTOOptional;
    }
}
