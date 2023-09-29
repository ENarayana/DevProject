package test.api.devproject.services;


import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Product;

public interface Productservices {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById (Long id);

}
