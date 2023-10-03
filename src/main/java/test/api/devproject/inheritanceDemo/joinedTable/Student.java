package test.api.devproject.inheritanceDemo.joinedTable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "jt_student")
public class Student extends User {
    private double psp;
    private double attendance;
}

