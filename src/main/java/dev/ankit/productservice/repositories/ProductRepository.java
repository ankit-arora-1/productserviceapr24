package dev.ankit.productservice.repositories;

import dev.ankit.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product entity);

    Product findByIdIs(Long id);

    List<Product> findAll();

    // @Query("select * from Product where id = 1") // HQL -> Hibernate query language
//    Product getTheBestProduct();
}
