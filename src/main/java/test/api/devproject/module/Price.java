package test.api.devproject.module;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jdk.jfr.SettingDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Price extends BaseModule{


  private String currency;

//    @Column(name = "price_column", columnDefinition = "NUMERIC")
//   private double price;

    @Column(name = "price_column")
    private double price;
}