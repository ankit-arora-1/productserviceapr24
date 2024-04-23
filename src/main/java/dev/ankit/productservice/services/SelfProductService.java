package dev.ankit.productservice.services;

import dev.ankit.productservice.models.Category;
import dev.ankit.productservice.models.Product;
import dev.ankit.productservice.repositories.CategoryRepository;
import dev.ankit.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) {
        return productRepository.findByIdIs(id);
    }

    @Override
    public Product createProduct(String title, String description, String image, String categoryTitle, double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category categoryFromDatabase = categoryRepository.findByTitle(categoryTitle);
        if(categoryFromDatabase == null) {
            Category newCategory = new Category();
            newCategory.setTitle(categoryTitle);
            categoryFromDatabase = newCategory;
            // categoryFromDatabase = categoryRepository.save(newCategory);
        }

        // If category was found from DB, then no new category will be created
        // If category is not found in the DB, a new category will be created because of cascade persist type
        product.setCategory(categoryFromDatabase);

        List<Product> productsTemp = categoryFromDatabase.getProducts();

        return productRepository.save(product);

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
