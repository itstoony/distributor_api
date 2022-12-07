package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
