package com.techstore.api.service;
import com.techstore.api.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
    List<ProductDTO> searchProductsByName(String name);
    List<ProductDTO> searchProductsByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
}
