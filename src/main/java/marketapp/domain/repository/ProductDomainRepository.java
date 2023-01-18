package marketapp.domain.repository;

import marketapp.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDomainRepository {

    List<Product> getAll();
    Optional<Product> getProductByID(Integer productID);

    Optional<Product> getProductByName(String productName);
    Product saveProduct(Product product);
    Boolean deleteProduct(Integer productId);

}
