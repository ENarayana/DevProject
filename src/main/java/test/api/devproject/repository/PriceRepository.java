package test.api.devproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.api.devproject.module.Price;

public interface PriceRepository extends JpaRepository<Price,Long> {

}
