package distribuitor.itstoony.com.github.repository;

import distribuitor.itstoony.com.github.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
