package com.meli.praticamogo.services;

import com.meli.praticamogo.domain.Category;
import com.meli.praticamogo.domain.Product;
import com.meli.praticamogo.dto.ProductDTO;
import com.meli.praticamogo.form.ProductForm;
import com.meli.praticamogo.repository.CategoryRepository;
import com.meli.praticamogo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ProductDTO> listAll() {
        return this.productRepository.findAll().stream().map(
                product -> modelMapper.map(product, ProductDTO.class)
        ).collect(Collectors.toList());
    }

    public ProductDTO find(String id) {
        Optional<Product> product = this.productRepository.findById(id);

        return modelMapper.map(product.get(), ProductDTO.class);
    }

    public ProductDTO create(ProductForm productForm) {
        Optional<Category> category = this.categoryRepository.findById(productForm.getCategory_id());

        Product product = new Product(productForm.getName(), productForm.getPrice(), category.get());

        this.productRepository.save(product);

        return modelMapper.map(product, ProductDTO.class);
    }

    public ProductDTO update(ProductForm productForm, String id) {
        Optional<Category> category = this.categoryRepository.findById(productForm.getCategory_id());

        Optional<Product> product = this.productRepository.findById(id);

        product.ifPresent(value -> {
            value.setName(productForm.getName());
            value.setPrice(productForm.getPrice());
            value.setCategory(category.get());
        });

        this.productRepository.save(product.get());

        return modelMapper.map(product.get(), ProductDTO.class);
    }

    public void delete(String id) {
        this.productRepository.deleteById(id);
    }
}
