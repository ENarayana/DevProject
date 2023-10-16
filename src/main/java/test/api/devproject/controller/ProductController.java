package test.api.devproject.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.module.Product;
import test.api.devproject.services.Productservices;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/product")
public class ProductController {
    //    @Autowired
    // field injection
    //   private ProductService productService;
    private Productservices productservices;


    // constructor injection
//    @Autowired
    public ProductController(Productservices productservices) {
        this.productservices = productservices;
    }
//

    // setter injection
//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    // GET /products {}
    @GetMapping
    public ResponseEntity<List<GenericProductDto>> getProducts() {
        List<GenericProductDto> productDtos = productservices.getProducts();
        if (productDtos.isEmpty()) {
            return new ResponseEntity<>(
                    productDtos,
                    HttpStatus.NOT_FOUND
            );
        }

        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (GenericProductDto gpd: productDtos) {
            genericProductDtos.add(gpd);
        };

//        genericProductDtos.remove(genericProductDtos.get(0));

        return new ResponseEntity<>(genericProductDtos, HttpStatus.OK);

//        productDtos.get(0).setId(1001L);
//
//        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    // localhost:8080/products/{id}
    // localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) { //throws NotFoundException {
        GenericProductDto productDto = productservices.getProductById(id);
//        if (productDto == null) {
//            throw new NotFoundException("Product Doesn't Exist");
//        }

//        GenericProductDto genericProductDto = new GenericProductDto();
//        genericProductDto.setTitle(productDto.getTitle());
        return productDto;

//        Comparator
    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(
//                productservices.deleteProduct(id),
//                HttpStatus.OK
//        );
//    }

//    @PostMapping
//    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
////        System.out.println(product.name);
//        return productservices.createProduct(product);
//    }


    @PostMapping ("/newproduct")
    public GenericProductDto postProduct(@RequestBody GenericProductDto genericProductDto) {
        return productservices.createProduct(genericProductDto);
    }

    @GetMapping("/newGetAllProducts")
    public List<GenericProductDto> getAllProducts(){
        return productservices.getProducts();
    }

    @GetMapping("/getSingleProduct/{id}")
    public GenericProductDto getSingleProductById(@PathVariable("id") Long id){
        return productservices.getProductSingle(id);
    }

    @PutMapping("/updateByID/{id}")
    public GenericProductDto updateProductById(@PathVariable Long id,@RequestBody GenericProductDto genericProductDto) {
        return productservices.updateProduct(id, genericProductDto);
    }

    @DeleteMapping("/deleteByid/{id}")
    public void deleteProductById(@PathVariable Long id){
        productservices.deleteProduct(id);
    }

        @GetMapping("/paged")
        public ResponseEntity<Page<GenericProductDto>> getProducts(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size) {

            Page<GenericProductDto> productDtos = productservices.getProducts(page, size);
            return ResponseEntity.ok(productDtos);
        }


}

