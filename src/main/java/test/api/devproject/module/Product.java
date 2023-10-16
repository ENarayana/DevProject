package test.api.devproject.module;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModule {

    private String title;
    private String description;
    private String image;

   @OneToOne(fetch = FetchType.EAGER)
    //@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    private Price price;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category")
    private Category category;

}
