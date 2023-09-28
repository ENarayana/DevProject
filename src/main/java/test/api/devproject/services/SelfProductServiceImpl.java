package test.api.devproject.services;

import org.springframework.stereotype.Service;

@Service ("SelfProductServiceImpl")
public class SelfProductServiceImpl implements Productservices {

    @Override
    public String getProductById(Long id) {
        return null;
    }
}
