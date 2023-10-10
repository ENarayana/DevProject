package test.api.devproject.Dto;

import lombok.Getter;
import lombok.Setter;
import test.api.devproject.module.Category;
import test.api.devproject.module.Price;

import java.util.UUID;

@Getter
@Setter
public class GenericProductDto {

    private String id;
    private String title;
    private String description;
    private Price price = new Price();
    private String image;
    private String category;
    private String name;

    public void setId(UUID id){
        if (id != null){
            this.id = id.toString();
        }
    }


//    public void setId(UUID productId) {
//
//    }

//    public void setId(Long id) {
//
//    }

    //   public void setId(UUID productId) {

    }

