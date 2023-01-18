package marketapp.domain.repository;

import marketapp.persistence.entity.Product;
import marketapp.persistence.entity.Search;

import java.util.List;
import java.util.Optional;

public interface SearchDomainRepository {

    List<Search> getAll();
    Optional<Search> getSearchByID(Integer productID);
    Search saveSearch(Search search);
    Boolean deleteSearch(Integer productID);
    List<Search> getMostSearchedProducts();
}
