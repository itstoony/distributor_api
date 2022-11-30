package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
}