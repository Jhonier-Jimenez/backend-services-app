package marketapp.persistence.repository;

import marketapp.domain.repository.ProductDomainRepository;
import marketapp.persistence.crud.ProductCrudRepository;
import marketapp.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductPersistenceRepository implements ProductDomainRepository {


    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Override
    public List<Product> getAll() {

        List<Product> productList = (List<Product>) productCrudRepository.findAll();
        return productList;
    }

    @Override
    public Optional<Product> getProductByID(Integer productID) {
        Optional<Product> product = productCrudRepository.findById(productID);
        return product;
    }

    @Override
    public Optional<Product> getProductByName(String productName) {
        Optional<Product> product = productCrudRepository.getProductByName(productName);
        return product;
    }

    @Override
    public Product saveProduct(Product product) {
        return productCrudRepository.save(product);
    }

    @Override
    public Boolean deleteProduct(Integer productId) {
        Optional<Product> productOptional = getProductByID(productId);

        if (productOptional.isPresent()){
            productCrudRepository.delete(productOptional.get());
            return true;
        }
        return false;
    }
}
