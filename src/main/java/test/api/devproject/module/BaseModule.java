package test.api.devproject.module;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@MappedSuperclass
public class BaseModule {

    @Id
    @GeneratedValue(generator = "uuidgenerator")
    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
    @Column (name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID uuid;

    public void setId(UUID productId) {

    }

//    public UUID getUuid(){
//        return uuid;
//    }


//    public void setId(UUID productId) {
//
//    }

    //private Long id;
}
