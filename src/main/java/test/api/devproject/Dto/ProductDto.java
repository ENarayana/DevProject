package test.api.devproject.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import test.api.devproject.module.Price;

@Getter
@Setter
public class ProductDto {
    private String title;

    private String description;

    private String image;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

    private Price price;

    }
