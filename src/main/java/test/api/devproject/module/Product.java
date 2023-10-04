package test.api.devproject.module;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModule{

    private String title;
    private String description;
    private String image;
    @ManyToOne
    private Category category;
    @OneToOne
    private Price price;


}
