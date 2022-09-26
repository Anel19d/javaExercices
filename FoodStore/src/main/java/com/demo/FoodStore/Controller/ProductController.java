package com.demo.FoodStore.Controller;

import com.demo.FoodStore.Service.ProductService;
import com.demo.FoodStore.dto.CategoryDTO;
import com.demo.FoodStore.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity getProducts(@RequestParam(name = "search", required = false) String search){
        return new ResponseEntity(productService.getAll(search), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable Long id){
        return new ResponseEntity(productService.getById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProductDTO dto){
        return new ResponseEntity(productService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id, @RequestBody ProductDTO dto){
        return new ResponseEntity(productService.update(id,dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id){
        try {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
