package test.api.devproject.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import test.api.devproject.module.Category;
import test.api.devproject.module.Price;

import java.util.UUID;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GenericProductDto {

    private String id;
    private String title;
    private String description;
    private Price price = new Price();
    private String image;
   // private String category;
    private String name;


// Other properties and getters/setters


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

