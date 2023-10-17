package test.api.devproject.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.api.devproject.module.Category;
import test.api.devproject.module.Product;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategoryIn(List<Category> categories);

    @Query(value = CustomQueries.FIND_ALL_BY_TITLE, nativeQuery = true)
    List<Product> findAllByTitle(String naman);

    Page<Product> findAll(Pageable pageable);

    List<Product> findAll(Specification<Product> spec);

    Page<Product> findAll(Specification<Product> spec, Pageable pageable);

}
