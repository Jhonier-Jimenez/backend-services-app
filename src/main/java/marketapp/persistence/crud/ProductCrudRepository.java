package marketapp.persistence.crud;

import marketapp.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository <Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE LOWER(name) = LOWER(?) ORDER BY name", nativeQuery = true)
    Optional<Product> getProductByName(String productName);
}
