package com.meli.praticamogo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductDTO {
    private String name;

    public ProductDTO(String name) {
        this.name = name;
    }
}
