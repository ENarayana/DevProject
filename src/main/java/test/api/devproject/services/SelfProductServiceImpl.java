package test.api.devproject.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
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
import java.util.Map;
import java.util.Optional;

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

        Category category = new Category();
        category.setName(genericProductDto.getName());
        category.setId(genericProductDto.getId());
        categoryRepository.save(category);

        Price price = new Price();
        price.setPrice(genericProductDto.getPrice().getPrice());
        price.setCurrency(genericProductDto.getPrice().getCurrency());
        price.setId(genericProductDto.getPrice().getId());
        priceRepository.save(price);

        Product product = new Product();

        product.setId(genericProductDto.getId());
        product.setTitle(genericProductDto.getTitle());
        product.setImage(genericProductDto.getImage());
        product.setDescription(genericProductDto.getDescription());
        product.setCategory(category); // genericProductDto.getCategory()
        product.setPrice(price);
        productRepository.save(product);

        genericProductDto.setId(product.getId());
        genericProductDto.getPrice().setId(price.getId());

        return genericProductDto;
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto genericProductDto) {

        Product productUpdate = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product Not found: " + id));

        // productUpdate.setId(genericProductDto.getId());
        productUpdate.setImage(genericProductDto.getImage());
        productUpdate.setDescription(genericProductDto.getDescription());
        productUpdate.setTitle(genericProductDto.getTitle());

        productUpdate.getCategory().setName(genericProductDto.getName());

        productUpdate.getPrice().setPrice(genericProductDto.getPrice().getPrice());
        productUpdate.getPrice().setCurrency(genericProductDto.getPrice().getCurrency());

        Product updatedProduct = productRepository.save(productUpdate);

        genericProductDto.setId(updatedProduct.getId());
        genericProductDto.getPrice().setId(updatedProduct.getPrice().getId());

        return genericProductDto;
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
            genericProductDto.setId(product.getId());
            productDtos.add(genericProductDto);
        }
        return productDtos;
    }

    @Override
    public GenericProductDto getProductSingle(Long id) {
//      System.out.println("Received id: " + id);
        Optional<Product> productOptional = productRepository.findById(id);
//      System.out.println("Product present: " + productOptional.isPresent());
        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setId(product.getId());
            genericProductDto.setName(product.getCategory().getName());
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setTitle(product.getTitle());
            genericProductDto.setPrice(product.getPrice());

            return genericProductDto;
        } else {
            throw new ProductNotFoundException("Product not found for id: " + id);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        // Check if the product with the given ID exists
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            // The product exists, so delete it
            Product product = productOptional.get();
            productRepository.deleteById(id);
        } else {
            // If the product doesn't exist, you can throw an exception or handle the situation as per your requirements
            throw new ProductNotFoundException("Product not found for id: " + id);
        }
    }


    @Override
    public Page<GenericProductDto> getProducts(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Order.asc("title")));
        Page<Product> productsPage = productRepository.findAll(pageRequest);

        Page<GenericProductDto> productDtos = productsPage.map(this::mapToDto);
        return productDtos;
    }

    private GenericProductDto mapToDto(Product product) {
        GenericProductDto dto = new GenericProductDto();
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setDescription(product.getDescription());
        dto.setImage(product.getImage());
        dto.setPrice(product.getPrice());
        dto.setName(product.getCategory().getName());
        return dto;
    }


    @Override
    public Page<GenericProductDto> filterProducts(Map<String, String> filterParams, int page, int size) {
        // Create a Pageable instance to handle pagination
        Pageable pageable = PageRequest.of(page, size);

        // Build the Specification for dynamic filtering
        Specification<Product> spec = (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            for (Map.Entry<String, String> entry : filterParams.entrySet()) {
                String field = entry.getKey();
                String value = entry.getValue();
                if (field != null && value != null) {
                    predicate = criteriaBuilder.and(
                            predicate,
                            criteriaBuilder.equal(root.get(field), value)
                    );
                }
            }
            return predicate;
        };

        // Use the Specification and pageable to filter products
        Page<Product> filteredProducts = productRepository.findAll(spec, pageable);

        // Map the filtered products to DTOs
        Page<GenericProductDto> productDtos = filteredProducts.map(this::mapToDto);

        return productDtos;
    }



}




