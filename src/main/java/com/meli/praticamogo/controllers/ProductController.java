package com.meli.praticamogo.controllers;

import com.meli.praticamogo.form.ProductForm;
import com.meli.praticamogo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(productService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return ResponseEntity.ok(productService.find(id));
    }

    @PostMapping
    public ResponseEntity<?> store(@RequestBody @Valid ProductForm productForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ProductForm productForm, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(productForm, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
