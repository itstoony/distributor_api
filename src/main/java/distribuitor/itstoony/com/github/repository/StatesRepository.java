package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.States;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatesRepository extends JpaRepository<States, Long> {
}