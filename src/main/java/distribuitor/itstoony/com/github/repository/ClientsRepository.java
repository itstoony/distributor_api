package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Costumer, Long> {

    Page<Costumer> findAllByName(String name, Pageable pageable);
    Costumer findAllByName(String name);

    Page<Costumer> findByName(String name, Pageable pageable);

    @Query("select u.name, u.cpf, u.address.zipcode from Costumer u where u.name like %:name%")
    Page<Costumer> findByPageableClientsName(@Param("name") String name, Pageable clientsRequest);
}