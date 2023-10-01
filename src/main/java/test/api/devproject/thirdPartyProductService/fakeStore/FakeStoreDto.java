package test.api.devproject.thirdPartyProductService.fakeStore;

import lombok.Getter;
import lombok.Setter;
import test.api.devproject.module.Category;
@Setter
@Getter
public class FakeStoreDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}

