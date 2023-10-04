package test.api.devproject.module;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModule{

    private String title;
    private String description;
    private double price;
    private String image;
    @ManyToOne
    private Category category;


}
