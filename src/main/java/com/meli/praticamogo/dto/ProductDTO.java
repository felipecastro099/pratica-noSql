package com.meli.praticamogo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class ProductDTO {
    private String id;
    private String name;
    private BigDecimal price;
    private CategoryDTO category;

    public ProductDTO(String id, String name, BigDecimal price, CategoryDTO category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
