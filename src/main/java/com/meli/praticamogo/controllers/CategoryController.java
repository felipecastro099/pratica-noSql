package com.meli.praticamogo.controllers;

import com.meli.praticamogo.form.CategoryForm;
import com.meli.praticamogo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(categoryService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.find(id));
    }

    @PostMapping
    public ResponseEntity<?> store(@RequestBody @Valid CategoryForm categoryForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(categoryForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid CategoryForm categoryForm, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(categoryForm, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
