package dev.ankit.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
@Entity
public class Category extends BaseModel {
    private String title;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JsonIgnore
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products;
}
