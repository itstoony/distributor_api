package distribuitor.itstoony.com.github.service;

import distribuitor.itstoony.com.github.model.Product;
import distribuitor.itstoony.com.github.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void insert(Product product){
        productRepository.save(product);
    }


    @Transactional
    public Product createProduct(String name, String description, double value, double weight) {
        return Product.builder()
                .name(name)
                .description(description)
                .value(value)
                .weight(weight)
                .build();
    }


}
