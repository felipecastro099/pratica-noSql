package com.meli.praticamogo.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CategoryForm {
    @NotNull
    @NotBlank
    private String name;

    public CategoryForm(String name) {
        this.name = name;
    }
}
