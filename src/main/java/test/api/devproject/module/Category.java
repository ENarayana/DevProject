package test.api.devproject.module;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModule {

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
   // private int id;

}
