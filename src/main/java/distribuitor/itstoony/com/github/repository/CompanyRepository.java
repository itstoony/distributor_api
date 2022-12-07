package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
