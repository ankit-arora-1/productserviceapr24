package dev.ankit.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel implements Serializable {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    // private int quantity;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;
}
