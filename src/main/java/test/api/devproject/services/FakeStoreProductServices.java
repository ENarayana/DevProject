package test.api.devproject.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.thirdPartyProductService.fakeStore.FakeStoreDto;
import test.api.devproject.thirdPartyProductService.fakeStore.FakeStoreProductServiceClient;

import java.util.*;

@Repository("FakeStoreProductServices")
public abstract class FakeStoreProductServices implements Productservices {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;


    private GenericProductDto convertFakeStoreProductIntoGenericProduct (FakeStoreDto fakeStoreDto) {
        GenericProductDto product = new GenericProductDto();

        //    product.setId(fakeStoreDto.getId());
        product.setImage(fakeStoreDto.getImage());
        product.setDescription(fakeStoreDto.getDescription());
        product.setTitle(fakeStoreDto.getTitle());
        //  product.setPrice(fakeStoreDto.getPrice());
        //   product.setCategory(fakeStoreDto.getCategory());

        return product;
    }

    public FakeStoreProductServices (FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

//    public GenericProductDto updateProduct(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        String updateUrl = updateProductRequestUrl.replace("{id}", String.valueOf(id));
//          ResponseEntity<GenericProductDto> response =
//                  restTemplate.exchange(updateUrl, HttpMethod.PUT, null, GenericProductDto.class);
//        return response.getBody();
//    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto product) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.updateProduct(id,product));
    }

    @Override
    public GenericProductDto getProductById(Long id) {

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreDto fakeStoreDto : fakeStoreProductServiceClient.getProducts()){
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreDto));
        }
        return genericProductDtos;
    }

    @Override
    public void deleteProduct(Long id) {

    }

//    @Override
//    public GenericProductDto deleteProduct(Long id) {
//
//        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProduct(id));
//    }

    @Override
    public GenericProductDto getProductSingle(Long id) {
        return null;
    }
}