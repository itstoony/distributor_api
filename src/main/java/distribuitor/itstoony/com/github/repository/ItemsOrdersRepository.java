package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.ItemsOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsOrdersRepository extends JpaRepository<ItemsOrders, Long> {
}