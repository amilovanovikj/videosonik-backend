package mk.com.videosonik.store.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "cart")
@Entity(name = "Cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CartCK.class)
public class Cart {

    //@EmbeddedId
//    private CartCK cartCK;

    @Id
    @JoinColumn(name = "id")
    private Integer id;

    @Id
    @JoinColumn(name = "username")
    @ManyToOne
    private User username;


    @Id
    @JoinColumn(name = "productid")
    @ManyToOne
    private Product productid;


    private int quantity;

    static public CartHistory transformToCartHistory(Cart cart) {
        return new CartHistory(cart.getId(), cart.getUsername(), cart.getProductid(), cart.getQuantity());
    }

}
