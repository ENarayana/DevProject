//package test.api.devproject;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import test.api.devproject.module.Product;
//
//@SpringBootApplication
//public class ScalerprojectApplication  {
//
//
//	public static void main(String[] args) {
//		SpringApplication.run(ScalerprojectApplication.class, args);
//
//	}
//
//}

//
//package test.api.devproject;
//
//import jakarta.transaction.Transactional;
//import org.hibernate.Hibernate;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import test.api.devproject.module.Category;
//import test.api.devproject.module.Price;
//import test.api.devproject.module.Product;
//import test.api.devproject.repository.CategoryRepository;
//import test.api.devproject.repository.PriceRepository;
//import test.api.devproject.repository.ProductRepository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@SpringBootApplication
//public class ScalerprojectApplication {// implements CommandLineRunner {
//
//    //  private MentorRepository mentorRepository;
//
//
//    //  private UserRepository userRepository;
//
//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//
//    public ScalerprojectApplication(ProductRepository productRepository,
//                                    CategoryRepository categoryRepository,
//                                    PriceRepository priceRepository) {
//        //    this.mentorRepository = mentorRepository;
//        //    this.userRepository = userRepository;
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(ScalerprojectApplication.class, args);
//    }
//    public void someMethod() {
//        Category category = new Category();
//        category.setName("Apple Devices");
//        // Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price("Rupee", 10);
//        // Price savedPrice = priceRepository.save(price);
//
//        Product product = new Product();
//        product.setTitle("iPhone 15 Pro");
//        product.setDescription("The best iPhone Ever");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
//
//        productRepository.deleteById(UUID.fromString("95672ed6-3127-4248-ae33-97a261c0a6f4"));
//
//       System.out.println(productRepository.countAllByPrice_Currency("Rupee"));
//        List<Product> products = productRepository.findAllByPrice_Currency("Rupee");
//    }
//}

package test.api.devproject;

import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import test.api.devproject.module.Category;
import test.api.devproject.module.Price;
import test.api.devproject.module.Product;
import test.api.devproject.repository.CategoryRepository;
import test.api.devproject.repository.PriceRepository;
import test.api.devproject.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ScalerprojectApplication {// implements CommandLineRunner {

//    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//
//    public ScalerprojectApplication(ProductRepository productRepository,
//                                    CategoryRepository categoryRepository,
//                                    PriceRepository priceRepository) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ScalerprojectApplication.class, args);
    }

//    public void someMethod() {
//        Category category = new Category();
//        category.setName("Apple Devices");
//
//        Price price = new Price("Rupee", 10);
//
//        Product product = new Product();
//        product.setTitle("iPhone 15 Pro");
//        product.setDescription("The best iPhone Ever");
//        product.setCategory(category);
//        product.setPrice(price);
//
//        productRepository.save(product);
//
//        productRepository.deleteById(UUID.fromString("95672ed6-3127-4248-ae33-97a261c0a6f4"));
//
//   //     System.out.println(productRepository.countAllByPrice_Currency("Rupee"));
//        List<Product> products = productRepository.findAllByPrice_Currency("Rupee");
//    }
}
