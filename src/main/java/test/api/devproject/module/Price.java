package test.api.devproject.module;

import jakarta.persistence.Entity;
import jdk.jfr.SettingDefinition;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Price extends BaseModule{

    String currency;
    double price = 0;
}
