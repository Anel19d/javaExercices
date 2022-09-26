package com.demo.FoodStore.Controller;

import com.demo.FoodStore.Service.CategoryService;
import com.demo.FoodStore.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity getCategory(@RequestParam(defaultValue = "", required = false) String search){
        System.out.println("Entered");
        return new ResponseEntity(categoryService.getAllCategories(search), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable Long id){
        return new ResponseEntity(categoryService.getById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody CategoryDTO dto){
        return new ResponseEntity(categoryService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id, @RequestBody CategoryDTO dto){
        return new ResponseEntity(categoryService.update(id,dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id){
        try {
            categoryService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
