package com.techstore.api.service;
import com.techstore.api.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO createProduct(ProductDTO productDTO);
}
