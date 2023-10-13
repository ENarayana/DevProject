package test.api.devproject.services;

import test.api.devproject.module.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(Long id);
    List<String> getProductTitles(List<Long> categoryIDs);

    List<String> findAllCategories();
}
