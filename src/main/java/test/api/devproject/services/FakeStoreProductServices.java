package test.api.devproject.services;

import org.springframework.stereotype.Service;

@Service ("FakeStoreProductServices")
public class FakeStoreProductServices implements Productservices {

    @Override
    public String getProductById(Long id) {
        return "Scaler Project " + id;
      //  return null;
    }
}
