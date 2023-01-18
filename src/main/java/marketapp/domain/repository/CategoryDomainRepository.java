package marketapp.domain.repository;

import marketapp.persistence.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryDomainRepository {

    List<Category> getAll();

    Optional<Category> getCategoryByID(Integer categoryID);

    Category saveCategory(Category category);

    Boolean deleteCategory(Integer productId);

}
