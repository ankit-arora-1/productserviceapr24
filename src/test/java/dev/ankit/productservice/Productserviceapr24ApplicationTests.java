package dev.ankit.productservice;

import dev.ankit.productservice.models.Category;
import dev.ankit.productservice.models.Product;
import dev.ankit.productservice.repositories.CategoryRepository;
import dev.ankit.productservice.repositories.ProductRepository;
import dev.ankit.productservice.repositories.projections.ProductWithTitleAndId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
class Productserviceapr24ApplicationTests {

    @Autowired // -- Tells spring to inject the object of prod repo
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testingQuery() {
        Product product = productRepository
                .getProductWithASpecificTitleAndId("electronics", 1L);

        System.out.println(product.getTitle());
    }

    @Test
    public void testingQuery2() {
        ProductWithTitleAndId product = productRepository
                .getProductWithASpecificTitleAndId2("iPhone12", 1L);

        System.out.println(product.getId());
        System.out.println(product.getTitle());
        System.out.println(product.getDescription());
    }

    @Test
    @Transactional
    public void testingFetchTypes() {
        Category category = categoryRepository.findByTitle("electronics");
        System.out.println(category.getProducts());
    }

    @Test
    public void testingFetchTypes2() {
        Category category = categoryRepository.findByTitle("electronics");
        System.out.println(category.getTitle());
    }

    @Test
    public void testingFetchTypes3() {
        Optional<Category> category = categoryRepository.findById(1L);
        System.out.println(category.get().getTitle());
    }

}
