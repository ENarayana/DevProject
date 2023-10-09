package test.api.devproject.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Category;
import test.api.devproject.module.Price;
import test.api.devproject.module.Product;
import test.api.devproject.repository.CategoryRepository;
import test.api.devproject.repository.PriceRepository;
import test.api.devproject.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service ("SelfProductServiceImpl")
public class SelfProductServiceImpl implements Productservices {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;

    public SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        Category category=null;

        Optional<Category> category1 = categoryRepository.findByName(genericProductDto.getCategory().getName());

        if(category1.isEmpty()){
            category = new Category();
            category.setName(String.valueOf(genericProductDto.getCategory()));
            categoryRepository.save(category);
        }else{
            category = category1.get();
        }

        Product product = new Product();
        product.setTitle(genericProductDto.getTitle());
        product.setImage(genericProductDto.getImage());
        product.setDescription(genericProductDto.getDescription());
        product.setCategory(genericProductDto.getCategory());
        product.setPrice(genericProductDto.getPrice());
        productRepository.save(product);

        Price price = new Price();
        price.setPrice(genericProductDto.getPrice().getPrice());
        price.setCurrency(genericProductDto.getPrice().getCurrency());
     //   productRepository.save(price);

  //      price.setCurrency(genericProductDto.getCurrency());

        return genericProductDto;
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