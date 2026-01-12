package com.techstore.api.controller;

import com.techstore.api.dto.ProductDTO;
import com.techstore.api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// Define REST API
@RequestMapping("/api/products")// Base URL
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping// Create
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        // @Valid DTO rules (NotNull, Min) check
        // @RequestBody JSON -> Java Object
        ProductDTO savedProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);// 201 Created Status
    }

    @GetMapping// Read
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products =  productService.getAllProducts();
        return ResponseEntity.ok(products);// 200 OK Status
    }

}
