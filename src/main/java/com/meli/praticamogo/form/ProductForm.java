package com.meli.praticamogo.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class ProductForm {
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    @NotBlank
    private String category_id;

    public ProductForm(String name, BigDecimal price, String category_id) {
        this.name = name;
        this.price = price;
        this.category_id = category_id;
    }
}
