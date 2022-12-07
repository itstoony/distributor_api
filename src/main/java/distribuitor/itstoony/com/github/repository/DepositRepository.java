package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

}
