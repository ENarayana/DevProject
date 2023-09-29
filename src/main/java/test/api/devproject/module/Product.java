package test.api.devproject.module;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModule{

    private String title;
    private String description;
    private double price;
    private String image;
    private Category category;
}
