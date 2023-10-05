package test.api.devproject.Dto;

import lombok.Getter;
import lombok.Setter;
import test.api.devproject.module.Price;

@Getter
@Setter
public class ProductDto {
    private String title;

    private String description;

    private String image;


    private double price;
    //            P : C
    // => L to R: 1 : 1
    // => R to L: m : 1
    // => Ans:    m : 1
    }
