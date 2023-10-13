package test.api.devproject.services;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Category;
import test.api.devproject.module.Price;
import test.api.devproject.module.Product;
import test.api.devproject.repository.CategoryRepository;
import test.api.devproject.repository.CustomQueries;
import test.api.devproject.repository.PriceRepository;
import test.api.devproject.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service ("SelfProductServiceImpl")
public class SelfProductServiceImpl implements Productservices {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;
    private CustomQueries customQueries;

    public SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository,
                                  PriceRepository priceRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
//        this.customQueries = customQueries;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
//        Category category=null;
//
//        Optional<Category> category1 = categoryRepository.findByName(genericProductDto.getCategory());
//        if (category1.isPresent()) {
//            // Category found, use it
//            category = category1.get();
//        } else {
//            // Category not found, create a new one
//            category = new Category();
//            category.setName(genericProductDto.getCategory());
//            categoryRepository.save(category);
//        }

        Category category = new Category();
        category.setName(genericProductDto.getName());
        categoryRepository.save(category);

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

        List<Product> optionalProduct = productRepository.findAll();

        List<GenericProductDto> productDtos = new ArrayList<>();

        for (Product product : optionalProduct) {

            Hibernate.initialize(product.getPrice());
            Hibernate.initialize(product.getCategory());
            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setName(product.getCategory().getName());
            genericProductDto.setTitle(product.getTitle());
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setPrice(product.getPrice());
           genericProductDto.setId(product.getUuid());

            productDtos.add(genericProductDto);
        }
        return productDtos;
    }

  @Override
    public GenericProductDto getProductSingle(UUID id){
//      System.out.println("Received id: " + id);
        Optional<Product> productOptional = productRepository.findById(id);
//      System.out.println("Product present: " + productOptional.isPresent());
        if(productOptional.isPresent()) {
            Product product = productOptional.get();

            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setId(product.getUuid());
            genericProductDto.setName(product.getCategory().getName());
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setTitle(product.getTitle());
            genericProductDto.setPrice(product.getPrice());

            return genericProductDto;
        }
        else {
            throw new ProductNotFoundException("Product not found for id: " + id);
        }
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

//            List<Product> products = productRepository.findAll();
//            List<GenericProductDto> product = new ArrayList<>();
//            products.forEach(prod -> {
//                GenericProductDto genericproduct = convertProductToGenericProduct(prod);
//                product.add(genericproduct);
//            });
//            return product;
//        }



    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}