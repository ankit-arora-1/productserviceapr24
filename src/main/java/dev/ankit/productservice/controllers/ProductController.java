package dev.ankit.productservice.controllers;

import dev.ankit.productservice.models.Product;
import dev.ankit.productservice.services.FakeStoreProductService;
import dev.ankit.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public void createProduct() {
        // Break for 5 minutes: 10:38 -> 10:43
    }

    @GetMapping("/products")
    public void getAllProducts() {

    }

    // Jackson
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        return productService.getSingleProduct(id);
    }

    public void deleteProduct(Long id) {

    }
}
