package mk.com.videosonik.store;

import mk.com.videosonik.store.model.*;
import mk.com.videosonik.store.repository.JPA.*;
import mk.com.videosonik.store.service.CartService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.List;

@Component
public class StarterDB {

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    @Value("${admin.email}")
    private String adminEmail;

    List<Review> reviewList;
    List<Cart>cartList;
    List<User>userList;
    List<Product>productList;

    // @Autowired
    // private CartRepositoryJPA cartRepositoryJPA;
    // @Autowired
    // private ProductRepositoryJPA productRepositoryJPA;
    // @Autowired
    // private ReviewRepositoryJPA reviewRepositoryJPA;
    // @Autowired
    // private UserRepositoryJPA userRepositoryJPA;
    @Autowired
    private AdminRepositoryJPA adminRepositoryJPA;

    private CartService cartService;

    @PostConstruct
    public void init() {
        userList = new LinkedList<>();
        productList = new LinkedList<>();
        cartList = new LinkedList<>();
        reviewList = new LinkedList<>();
        User user = new User(adminUsername, adminEmail, adminPassword, new LinkedList<>());
//        Product product = new Product("123", 200, "img", "descrptioasdo", "keywrds", 5,"LED");

//        userList.add(user);
//        productList.add(product);


//        cartList.add(new Cart(11, user, product, 25));
//        reviewList.add(new Review(2, user, product, "komentar", 2, ));

       /* userList = userRepositoryJPA.findAll();
        productList= productRepositoryJPA.findAll();
        for (User u :userList) {
            for (Product p :productList) {
                cartService.addProductToCart(p,u,5);
            }
        }*/

//        if(!userRepositoryJPA.findById(user.getUsername()).isPresent()){
//            userRepositoryJPA.save(user);
//        }
//            User piki = userRepositoryJPA.findById("test1").get();

            Admin admin = new Admin(user, Privileges.admin);
            adminRepositoryJPA.save(admin);

//        productRepositoryJPA.save(product);
//        cartRepositoryJPA.save(cartList.get(0));
//        reviewRepositoryJPA.save(reviewList.get(0));


//        Admin pikiadmin = adminRepositoryJPA.findById("Likson").get();
//        pikiadmin.setPrivileges(Privileges.sales);
//        adminRepositoryJPA.save(pikiadmin);

    }
}
