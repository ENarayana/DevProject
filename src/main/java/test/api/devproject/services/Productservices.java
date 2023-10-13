package test.api.devproject.services;


import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Product;

import java.util.List;
import java.util.UUID;

public interface Productservices {
    GenericProductDto createProduct(GenericProductDto genericProductDto);

    GenericProductDto updateProduct(Long id, GenericProductDto product);

    GenericProductDto getProductById (Long id);

    List<GenericProductDto> getProducts();

   // GenericProductDto getSingleProduct(UUID id);

    GenericProductDto deleteProduct(Long id);

    GenericProductDto getProductSingle(Long id);

}
