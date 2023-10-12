package test.api.devproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.api.devproject.Dto.GenericProductDto;

import java.util.List;
import java.util.UUID;

public interface CustomQueries {
    String FIND_ALL_BY_TITLE = "select * from product join product_orders " +
            "on product.id = product_orders.product_id where title = :naman";

//    GenericProductDto findProduct(UUID id);
//
//    List<GenericProductDto> findProductsByCategory(String category);
}
