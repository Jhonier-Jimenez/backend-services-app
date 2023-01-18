package marketapp.persistence.repository;

import marketapp.domain.repository.CategoryDomainRepository;
import marketapp.persistence.crud.CategoryCrudRepository;
import marketapp.persistence.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryPersistenceRepository implements CategoryDomainRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    @Override
    public List<Category> getAll() {
        List<Category> categoryList = (List<Category>) categoryCrudRepository.findAll();
        return categoryList;
    }

    @Override
    public Optional<Category> getCategoryByID(Integer categoryID) {
        Optional<Category> category = categoryCrudRepository.findById(categoryID);
        return category;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryCrudRepository.save(category);
    }

    @Override
    public Boolean deleteCategory(Integer productId) {

        Optional<Category> optionalCategory = categoryCrudRepository.findById(productId);

        if(optionalCategory.isPresent()){
            categoryCrudRepository.delete(optionalCategory.get());
            return true;
        }
        return false;
    }
}
