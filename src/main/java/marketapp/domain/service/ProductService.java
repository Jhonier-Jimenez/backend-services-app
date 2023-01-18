package marketapp.domain.service;

import marketapp.domain.repository.ProductDomainRepository;
import marketapp.persistence.entity.Product;
import marketapp.persistence.entity.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDomainRepository productDomainRepository;
    @Autowired
    SearchService searchService;

    public List<Product> getAllProducts(){
        return productDomainRepository.getAll();
    }

    public Optional<Product> getProductByID(Integer productID){
        searchService.saveSearch(productID);
        return productDomainRepository.getProductByID(productID);
    }

    public Optional<Product> getProductByName(String productName){

        Optional<Product> product = productDomainRepository.getProductByName(productName);

        if (product.isPresent()){
            searchService.saveSearch(product.get().getID());
        }
        return product;
    }

    public Product saveProduct(Product product){
        return productDomainRepository.saveProduct(product);
    }

    public Boolean deleteProduct(Integer productID){
        return productDomainRepository.deleteProduct(productID);
    }




}