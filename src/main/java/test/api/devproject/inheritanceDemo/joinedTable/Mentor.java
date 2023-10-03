package test.api.devproject.inheritanceDemo.joinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jt_mentor")
public class Mentor extends User {
    private double averageRating;

}


