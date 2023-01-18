package marketapp.domain.service;

import marketapp.domain.repository.CategoryDomainRepository;
import marketapp.persistence.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryDomainRepository categoryDomainRepository;


    public List<Category> getAllCategories(){
        return categoryDomainRepository.getAll();
    }

    public Optional<Category> getCategoryByID(Integer categoryID){
        return categoryDomainRepository.getCategoryByID(categoryID);
    }

    public Category saveCategory(Category category){
        return categoryDomainRepository.saveCategory(category);
    }

    public Boolean deleteCategory(Integer categoryID){
        return categoryDomainRepository.deleteCategory(categoryID);
    }
}
