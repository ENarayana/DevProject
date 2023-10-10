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

        Optional<Category> category1 = categoryRepository.findByName(genericProductDto.getCategory());
        if (category1.isPresent()) {
            // Category found, use it
            category = category1.get();
        } else {
            // Category not found, create a new one
            category = new Category();
            category.setName(genericProductDto.getCategory());
            categoryRepository.save(category);
        }


        Price price = new Price();
        price.setPrice(genericProductDto.getPrice().getPrice());
        price.setCurrency(genericProductDto.getPrice().getCurrency());
        priceRepository.save(price);

        Product product = new Product();
        UUID productId = UUID.randomUUID();  // Generate a unique ID
        product.setId(productId);  // Set the id on the Product entity
        product.setTitle(genericProductDto.getTitle());
        product.setImage(genericProductDto.getImage());
        product.setDescription(genericProductDto.getDescription());
        product.setCategory(category); // genericProductDto.getCategory()
        product.setPrice(price);
        productRepository.save(product);

       genericProductDto.setId(productId);

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