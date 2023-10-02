package test.api.devproject.module;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Builder
public class Product extends BaseModule{

    private String title;
    private String description;
    private double price;
    private String image;
    @ManyToOne
    private Category category;
}
