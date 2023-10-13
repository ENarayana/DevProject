package test.api.devproject.module;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModule {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;



    public void setId(Long id) {

    }

    public Long getId() {
        return id;
    }
}
//    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
//    @Column (name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
//    private UUID uuid;

//    public void setId(UUID productId) {
//
//    }

//    public UUID getUuid(){
//        return uuid;
//    }


//    public void setId(UUID productId) {
//
//    }

    //private Long id;
//}