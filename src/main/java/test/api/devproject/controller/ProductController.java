package test.api.devproject.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.api.devproject.Dto.GenericProductDto;
import test.api.devproject.services.Productservices;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/product")
public class ProductController {

//    @Autowired
//    @Qualifier("FakeStoreProductServices")
    private Productservices productservices;

    // Constructor Injection
    public ProductController (@Qualifier("FakeStoreProductServices") Productservices productservices) {
        this.productservices = productservices;
    }

    @GetMapping
    public List<GenericProductDto> gelAllProducts() {
        return productservices.getProducts();

    }
    //https:localhost:8080/product/{id}(Here {id} = 121 or any id run in postman)
    @GetMapping ("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        return productservices.getProductById(id);

    }
    @PostMapping
    public GenericProductDto postProduct(@RequestBody GenericProductDto product) {
        return productservices.createProduct(product);
      //  return "Create product: " + UUID.randomUUID();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productservices.deleteProduct(id), HttpStatus.NOT_FOUND);
    }
//
//    @PutMapping ("/{id}")
//    public GenericProductDto updateProductById(@PathVariable Long id) {
//        return productservices.updateProduct(id);
//
//    }
@PutMapping("/{id}")
public GenericProductDto updateProduct(@PathVariable Long id, @RequestBody GenericProductDto product) {
    return productservices.updateProduct(id, product);
}


}
