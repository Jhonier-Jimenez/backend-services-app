package marketapp.persistence.repository;

import marketapp.domain.repository.SearchDomainRepository;
import marketapp.persistence.crud.SearchCrudRepository;
import marketapp.persistence.entity.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SearchPersistenceRepository implements SearchDomainRepository {

    @Autowired
    private SearchCrudRepository searchCrudRepository;

    @Override
    public List<Search> getAll() {
        List<Search> searchList = (List<Search>) searchCrudRepository.findAll();
        return searchList;
    }

    @Override
    public Optional<Search> getSearchByID(Integer productID) {
        Optional<Search> search = searchCrudRepository.findById(productID);
        return search;
    }

    @Override
    public Search saveSearch(Search search) {
        return searchCrudRepository.save(search);
    }

    @Override
    public Boolean deleteSearch(Integer productID) {
        Optional<Search> searchOptional = getSearchByID(productID);

        if (searchOptional.isPresent()){
            searchCrudRepository.delete(searchOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public List<Search> getMostSearchedProducts() {
        List<Search> searchList = (List<Search>) searchCrudRepository.getSearchesBySearchCountOrderBySearchCountDesc();
        return searchList;
    }
}
