package test.api.devproject.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import test.api.devproject.Dto.FakeStoreDto;
import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Product;

import java.util.HashMap;
import java.util.Map;

@Service ("FakeStoreProductServices")
public class FakeStoreProductServices implements Productservices {

    private RestTemplateBuilder restTemplateBuilder;

    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";

    private String createProductRequestUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductServices (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response =
                restTemplate.postForEntity(createProductRequestUrl, product, GenericProductDto.class);

        return response.getBody();
            }

    @Override
    public GenericProductDto getProductById(Long id) {
        //   FakeStoreProductServices fakeStoreProductServices = new FakeStoreProductServices();
        RestTemplate restTemplate = restTemplateBuilder.build();

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("id", id);

        ResponseEntity<FakeStoreDto> response =
                restTemplate.getForEntity(getProductRequestUrl, FakeStoreDto.class, uriVariables);
        FakeStoreDto fakeStoreDto = response.getBody();

        GenericProductDto product = new GenericProductDto();

        product.setImage(fakeStoreDto.getImage());
        product.setDescription(fakeStoreDto.getDescription());
        product.setTitle(fakeStoreDto.getTitle());
        product.setPrice(fakeStoreDto.getPrice());
        product.setCategory(fakeStoreDto.getCategory());

        return product;
      //  return null;
    }
}
