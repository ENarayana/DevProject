package test.api.devproject.controller;

import org.springframework.web.bind.annotation.*;
import test.api.devproject.Dto.GetProductRequestDto;
import test.api.devproject.Dto.ProductDto;
import test.api.devproject.module.Product;
import test.api.devproject.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{uuid}")
    public List<ProductDto> getCategory(@PathVariable("uuid") String uuid) {
        List<Product> products = categoryService.getCategory(uuid).getProducts();

        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product: products) {
            ProductDto productDto = new ProductDto();
            productDto.setDescription(product.getDescription());
            productDto.setTitle(product.getTitle());
            productDto.setImage(product.getImage());
            productDto.setPrice(product.getPrice());
            productDtos.add(productDto);
//            productDto.se
        }

        return productDtos;
    }

    @GetMapping("/titles/")
    public List<String> getProductTitles(@RequestBody GetProductRequestDto requestDto) {

        List<String> uuids = requestDto.getUuids();

        return categoryService.getProductTitles(uuids);
    }
}
