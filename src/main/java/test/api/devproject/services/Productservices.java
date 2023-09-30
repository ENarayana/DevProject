package test.api.devproject.services;


import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Product;

import java.util.List;

public interface Productservices {
    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto updateProduct(Long id, GenericProductDto product);

    GenericProductDto getProductById (Long id);

    List<GenericProductDto> getProducts();

    GenericProductDto deleteProduct(Long id);
}
