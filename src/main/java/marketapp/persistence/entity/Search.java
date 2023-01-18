package marketapp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "search")
public class Search {

    //----------------TABLE COLUMNS-------------------------

    @Id
    @Column(name = "product_id")
    private Integer productID;

    @Column(name = "search_count")
    private Integer searchCount;

    //----------------RELATIONSHIPS--------------------------

    @OneToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"search", "id"})
    private Product product;

    //---------------- CONSTRUCTOR --------------------------

    public Search(Integer productID, Integer searchCount) {
        this.productID = productID;
        this.searchCount = searchCount;
    }

    public Search() {

    }

    //----------------GETTERS & SETTERS--------------------------


    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getSearchCount() {
        return searchCount;
    }

    public void setSearchCount(Integer searchCount) {
        this.searchCount = searchCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
