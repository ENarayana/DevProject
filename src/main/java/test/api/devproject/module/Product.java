package test.api.devproject.module;

import jakarta.persistence.*;
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

//    @ManyToOne(cascade = {CascadeType.PERSIST})
//    @JoinColumn(name = "category")
//    private Category category;
//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
////    @Fetch(FetchMode.JOIN)
//    private Price price;
//    private int inventoryCount;


}
