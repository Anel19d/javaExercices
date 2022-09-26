package com.demo.FoodStore.Entity;

import com.demo.FoodStore.dto.ProductDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Set;

@Entity
@Table(name ="product")
@Getter
@Setter
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "price")
    private Double price;

    @ManyToMany(mappedBy = "products")
    private Set<Order> order;


    public Product(ProductDTO dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
        Category category = new Category(dto.getCategory());
        this.category = category;
        this.price = dto.getPrice();
    }

    public Product() {

    }

}
