package marketapp.domain.service;


import marketapp.domain.repository.SearchDomainRepository;
import marketapp.persistence.entity.Product;
import marketapp.persistence.entity.Search;
import marketapp.persistence.repository.SearchPersistenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchService {

    @Autowired
    private SearchDomainRepository searchDomainRepository;

    public List<Search> getAllSearches(){
        return searchDomainRepository.getAll();
    }

    public Optional<Search> getSearchByID(Integer productID){
        return searchDomainRepository.getSearchByID(productID);
    }

    public Search saveSearch(Integer productID){
        Optional<Search> searchOptional = searchDomainRepository.getSearchByID(productID);

        if (searchOptional.isPresent()){
            Search search = searchOptional.get();
            Integer counter = search.getSearchCount() + 1;
            search.setSearchCount(counter);
            return searchDomainRepository.saveSearch(search);
        }

        Search search = new Search(productID, 0);
        return searchDomainRepository.saveSearch(search);
    }

    public Boolean deleteSearch(Integer productID){
        return searchDomainRepository.deleteSearch(productID);
    }

    public List<Search> getMostSearchedProducts(){
        return searchDomainRepository.getMostSearchedProducts();
    }
}
