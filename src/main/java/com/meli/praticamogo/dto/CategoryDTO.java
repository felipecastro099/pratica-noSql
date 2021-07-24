package com.meli.praticamogo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {
    private String id;
    private String name;

    public CategoryDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
