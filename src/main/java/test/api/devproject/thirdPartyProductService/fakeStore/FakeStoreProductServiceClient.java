package test.api.devproject.thirdPartyProductService.fakeStore;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import test.api.devproject.Dto.GenericProductDto;

import java.util.*;
@Service
public class FakeStoreProductServiceClient  {

    private RestTemplateBuilder restTemplateBuilder;

    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";

    private String productRequestBaseUrl = "https://fakestoreapi.com/products";

    private String updateProductRequestUrl = "https://fakestoreapi.com/products/{id}";

    public FakeStoreProductServiceClient (RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }



    public FakeStoreDto createProduct(GenericProductDto  product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreDto> response =
                restTemplate.postForEntity(productRequestBaseUrl, product, FakeStoreDto.class);

        return response.getBody();
    }

    public FakeStoreDto updateProduct(Long id, GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        String updateUrl = updateProductRequestUrl.replace("{id}", String.valueOf(id));
        HttpEntity<FakeStoreDto> requestEntity = new HttpEntity<>(updateProduct(id,product));

        ResponseEntity<FakeStoreDto> response =
                restTemplate.exchange(updateUrl, HttpMethod.PUT, requestEntity, FakeStoreDto.class);

        return response.getBody();
    }

    public FakeStoreDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("id", id);

        ResponseEntity<FakeStoreDto> response =
                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreDto.class, uriVariables);
        FakeStoreDto fakeStoreDto = response.getBody();

        return fakeStoreDto;
        //  return null;
    }

    public List<FakeStoreDto> getProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreDto[]> response =
                restTemplate.getForEntity(productRequestBaseUrl, FakeStoreDto[].class);

        List<FakeStoreDto> answer = new ArrayList<>();

        return Arrays.stream(response.getBody()).toList();
    }

    public FakeStoreDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreDto.class);

        ResponseExtractor<ResponseEntity<FakeStoreDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreDto.class);
        ResponseEntity<FakeStoreDto> response =
                restTemplate.execute(specificProductRequestUrl,HttpMethod.DELETE, requestCallback,responseExtractor,id);

        return response.getBody();
    }
}
