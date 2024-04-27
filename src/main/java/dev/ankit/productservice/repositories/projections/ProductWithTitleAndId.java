package dev.ankit.productservice.repositories.projections;

// Somwthing like DTOs except to get data from db and our app
public interface ProductWithTitleAndId {
    // put getter method for corresponding attributes
    Long getId();
    String getTitle();

    String getDescription();
}
