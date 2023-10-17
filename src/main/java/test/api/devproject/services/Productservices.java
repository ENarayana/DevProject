package test.api.devproject.services;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Product;

import java.util.List;
import java.util.Map;

public interface Productservices {
    GenericProductDto createProduct(GenericProductDto genericProductDto);

    GenericProductDto updateProduct(Long id, GenericProductDto product);

    GenericProductDto getProductById (Long id);

    List<GenericProductDto> getProducts();

    void deleteProduct(Long id);

    GenericProductDto getProductSingle(Long id);

    Page<GenericProductDto> getProducts(int page, int size);

    Page<GenericProductDto> filterProducts(Map<String, String> filterParams, int page, int size);

}