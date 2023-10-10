package test.api.devproject.Dto;

import lombok.Getter;
import lombok.Setter;
import test.api.devproject.module.Category;
import test.api.devproject.module.Price;

import java.util.UUID;

@Getter
@Setter

public class GenericProductDto {

    private Long id;
    private String title;
    private String description;
    private Price price = new Price();
    private String image;
    private Category category;

}
