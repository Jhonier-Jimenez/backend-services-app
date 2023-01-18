package marketapp.persistence.crud;

import marketapp.persistence.entity.Product;
import marketapp.persistence.entity.Search;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SearchCrudRepository extends CrudRepository<Search, Integer> {

    @Query(value = "SELECT * FROM search ORDER BY search_count DESC", nativeQuery = true)
    List<Search> getSearchesBySearchCountOrderBySearchCountDesc();
}
