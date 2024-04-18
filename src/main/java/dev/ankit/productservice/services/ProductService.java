package dev.ankit.productservice.services;

import dev.ankit.productservice.dtos.CreateProductRequestDto;
import dev.ankit.productservice.models.Product;

import java.util.List;

public interface ProductService {
    public Product getSingleProduct(Long id);
    public Product createProduct(String title, String description,
                                 String image, String category, double price);

    public List<Product> getAllProducts();
}
