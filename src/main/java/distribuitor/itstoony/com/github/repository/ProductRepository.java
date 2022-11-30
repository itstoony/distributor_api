package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}