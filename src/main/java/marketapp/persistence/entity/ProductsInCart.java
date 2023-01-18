package marketapp.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products_in_cart")
public class ProductsInCart {

    //----------------TABLE COLUMNS-------------------------

    @EmbeddedId
    private ProductsInCartPK ID;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    //----------------RELATIONSHIPS--------------------------

    @ManyToOne()
    @MapsId("product_id")
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne()
    @MapsId("cart_id")
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    private Cart cart;

    //----------------GETTERS & SETTERS--------------------------


    public ProductsInCartPK getID() {
        return ID;
    }

    public void setID(ProductsInCartPK ID) {
        this.ID = ID;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
