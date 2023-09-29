package test.api.devproject.Dto;

import lombok.Getter;
import lombok.Setter;
import test.api.devproject.module.Category;

@Getter
@Setter

public class GenericProductDto {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
