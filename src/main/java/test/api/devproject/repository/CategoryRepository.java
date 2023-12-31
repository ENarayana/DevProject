package test.api.devproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.api.devproject.module.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findById(Long id);

    @Override
    List<Category> findAllById(Iterable<Long> id);

    Optional<Category> findByName(String name);
}
