package test.api.devproject.services;

import org.springframework.stereotype.Service;
import test.api.devproject.module.Category;
import test.api.devproject.module.Product;
import test.api.devproject.repository.CategoryRepository;
import test.api.devproject.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Category getCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if (categoryOptional.isEmpty()) {
            return null;
        }

        Category category = categoryOptional.get();

        List<Product> products = category.getProducts();


        return category;
    }

    public List<String> getProductTitles(List<Long> categoryIDs) {
        List<Long> ids = new ArrayList<>();

        for (Long id : categoryIDs) {
            ids.add(id);
        }
//
//        List<Category> categories = categoryRepository.findAllById(uuids);
//
//
//        List<String> titles = new ArrayList<>();
//
//        categories.forEach(
//                category -> {
//                    category.getProducts().forEach(
//                            product -> {
//                                titles.add(product.getTitle());
//                            }
//                    );
//                }
//        );
//
//
//        return titles;

        List<Category> categories = categoryRepository.findAllById(ids);

        List<Product> products = productRepository.findAllByCategoryIn(categories);

        List<String> titles = new ArrayList<>();

        for (Product p: products) {
            titles.add(p.getTitle());
        }

        return titles;
    }

    @Override
    public List<String> findAllCategories() {
        return null;
    }
}
