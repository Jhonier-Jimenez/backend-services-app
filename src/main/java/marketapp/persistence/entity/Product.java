package marketapp.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    //----------------TABLE COLUMNS-------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String name;
    private String description;
    private Double price;
    private Double discount;

    @Column(name = "discount_price")
    private Double discountPrice;

    @Column(name = "category_id")
    private Integer categoryID;

    @Column(name = "images_id")
    private Integer imagesID;

    //----------------RELATIONSHIPS--------------------------
    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    @JsonIgnoreProperties("productList")
    private Category category;

/*    @ManyToOne
    @JoinColumn(name = "images_id", insertable = false, updatable = false)
    private Images images;*/

    @OneToOne(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private Search search;

    //----------------GETTERS & SETTERS--------------------------


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public Integer getImagesID() {
        return imagesID;
    }

    public void setImagesID(Integer imagesID) {
        this.imagesID = imagesID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

/*    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }*/

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
