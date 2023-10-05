package test.api.devproject.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Product;

import java.util.List;

@Primary
@Service ("SelfProductServiceImpl")
public class SelfProductServiceImpl implements Productservices {

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) {

        return new GenericProductDto();
    }

    @Override
    public List<GenericProductDto> getProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}