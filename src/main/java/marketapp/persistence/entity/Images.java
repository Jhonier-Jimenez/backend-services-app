package marketapp.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "images")
public class Images {

    //----------------TABLE COLUMNS-------------------------

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer ID;

    @ElementCollection
    @Column(name = "images_urls")
    private List<String> imagesUrls;

    //----------------RELATIONSHIPS--------------------------

/*    @OneToMany(mappedBy = "images")
    private List<Product> productImages;*/

    //----------------GETTERS & SETTERS--------------------------


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public List<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }

/*    public List<Product> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<Product> productImages) {
        this.productImages = productImages;
    }*/
}
