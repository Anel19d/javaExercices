package com.demo.FoodStore.Controller;

import com.demo.FoodStore.Repository.OrderRepository;
import com.demo.FoodStore.Service.OrderService;
import com.demo.FoodStore.dto.CategoryDTO;
import com.demo.FoodStore.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderDto>> getCategory(@RequestParam(name = "search", required = false) String search){
        try {
            List<OrderDto> orderResponse = orderService.getAll(search);
            return new ResponseEntity<List<OrderDto>>(orderResponse, HttpStatus.FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable Long id){
        return new ResponseEntity(orderService.getById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody OrderDto dto){
        return new ResponseEntity(orderService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id, @RequestBody OrderDto dto){
        return new ResponseEntity(orderService.update(id,dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity save(@PathVariable Long id){
        try {
            orderService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
