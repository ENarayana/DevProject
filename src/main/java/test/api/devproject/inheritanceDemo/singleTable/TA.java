package test.api.devproject.inheritanceDemo.singleTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "st_ta")
public class TA extends User {
    private double averageRating;
}
