package test.api.devproject.services;

import org.springframework.stereotype.Service;
import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Product;

@Service ("SelfProductServiceImpl")
public class SelfProductServiceImpl implements Productservices {

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }
}
