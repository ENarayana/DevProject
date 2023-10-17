package test.api.devproject.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    //    @Override
    //    public List<Product> findProductWithSorting(String field) {
    //        return productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    //
    //    }
//    Page<GenericProductDto> getProducts(int page, int size);


    Page<GenericProductDto> getProducts(int page, int size);

//    List<GenericProductDto> filterProducts(Map<String, String> filterParams);
}