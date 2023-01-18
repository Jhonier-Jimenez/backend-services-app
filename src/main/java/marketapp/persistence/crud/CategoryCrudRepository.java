package marketapp.persistence.crud;

import marketapp.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository <Category, Integer> {
}
