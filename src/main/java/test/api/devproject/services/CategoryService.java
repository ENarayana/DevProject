package test.api.devproject.services;

import test.api.devproject.module.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(String uuid);
    List<String> getProductTitles(List<String> categoryUUIDs);

    List<String> findAllCategories();
}
