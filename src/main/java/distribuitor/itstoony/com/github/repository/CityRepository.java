package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}