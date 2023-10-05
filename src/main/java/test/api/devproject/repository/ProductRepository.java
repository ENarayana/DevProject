package test.api.devproject.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import test.api.devproject.module.Category;
import test.api.devproject.module.Product;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

   // Product findByTitleEqualsAndPrice(double price);

     Product findByTitleEquals(String title);

    Product findByTitleEqualsAndPrice(String title, double price);

 //   List<Product> findAllByPrice_Currency(String currency);

    @Override
    void delete(Product entity);

    // long countAllByPrice_Currency(String currency);

    //List<Product> findAllByTitleLike(String titleRegex);

  //  List<Product> readAllByTitleLike(String titleRegex);


    List<Product> findAllByCategoryIn(List<Category> categories);

    //    @Query("select Product  from Product  where Product .category.uuid in :uuids")
//    List<Product> findAllByCategoryIn(List<UUID> uuids);

    @Query(value = CustomQueries.FIND_ALL_BY_TITLE, nativeQuery = true)
    List<Product> findAllByTitle(String naman);

//    @Query("select Product from Product where Product.price.currency = :currency and Product.title = :naman")
//    List<Product> doSomething(String SWAMY, String currency);
}

//    boolean countAllByPrice_Currency(String rupee);
//
//    List<Product> findAllByPrice_Currency(String rupee);

