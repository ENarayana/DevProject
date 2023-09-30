package test.api.devproject.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import test.api.devproject.Dto.FakeStoreDto;
import test.api.devproject.Dto.GenericProductDto;

import java.util.*;

@Service ("FakeStoreProductServices")
public class FakeStoreProductServices implements Productservices {

    private RestTemplateBuilder restTemplateBuilder;

    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";

    private String productRequestBaseUrl = "https://fakestoreapi.com/products";

    private String updateProductRequestUrl = "https://fakestoreapi.com/products/{id}";

    public FakeStoreProductServices (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private GenericProductDto convertFakeStoreProductIntoGenericProduct (FakeStoreDto fakeStoreDto) {
        GenericProductDto product = new GenericProductDto();

        product.setId(fakeStoreDto.getId());
        product.setImage(fakeStoreDto.getImage());
        product.setDescription(fakeStoreDto.getDescription());
        product.setTitle(fakeStoreDto.getTitle());
        product.setPrice(fakeStoreDto.getPrice());
        product.setCategory(fakeStoreDto.getCategory());

        return product;
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response =
                restTemplate.postForEntity(productRequestBaseUrl, product, GenericProductDto.class);

        return response.getBody();
            }

//    public GenericProductDto updateProduct(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        String updateUrl = updateProductRequestUrl.replace("{id}", String.valueOf(id));
//          ResponseEntity<GenericProductDto> response =
//                  restTemplate.exchange(updateUrl, HttpMethod.PUT, null, GenericProductDto.class);
//        return response.getBody();
//    }

    public GenericProductDto updateProduct(Long id, GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        String updateUrl = updateProductRequestUrl.replace("{id}", String.valueOf(id));
        HttpEntity<GenericProductDto> requestEntity = new HttpEntity<>(product);

        ResponseEntity<GenericProductDto> response =
                restTemplate.exchange(updateUrl, HttpMethod.PUT, requestEntity, GenericProductDto.class);

        return response.getBody();
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("id", id);

        ResponseEntity<FakeStoreDto> response =
                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreDto.class, uriVariables);
        FakeStoreDto fakeStoreDto = response.getBody();

        return convertFakeStoreProductIntoGenericProduct(fakeStoreDto);
      //  return null;
    }

    @Override
    public List<GenericProductDto> getProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        
        ResponseEntity<FakeStoreDto[]> response =
                restTemplate.getForEntity(productRequestBaseUrl, FakeStoreDto[].class);

        List<GenericProductDto> answer = new ArrayList<>();

        for(FakeStoreDto fakeStoreDto : Arrays.stream(response.getBody()).toList()) {
        GenericProductDto product = new GenericProductDto();

        answer.add(convertFakeStoreProductIntoGenericProduct(fakeStoreDto));
        }
        return answer;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreDto.class);

        ResponseExtractor<ResponseEntity<FakeStoreDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreDto.class);
        ResponseEntity<FakeStoreDto> response =
                restTemplate.execute(specificProductRequestUrl,HttpMethod.DELETE, requestCallback,responseExtractor,id);

        FakeStoreDto fakeStoreDto = response.getBody();

        return convertFakeStoreProductIntoGenericProduct(fakeStoreDto);
    }
}
