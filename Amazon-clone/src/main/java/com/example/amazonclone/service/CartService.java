package com.example.amazonclone.service;
import com.example.amazonclone.model.Cart;
import com.example.amazonclone.model.Product;
import com.example.amazonclone.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class CartService {

    private final UserService userService;
    private final ProductService productService;

    private final OrderService orderService;
    ArrayList<Cart> carts = new ArrayList<>();

    long cartNumber=100;

    public ArrayList<Cart> getAllCart() {
        return this.carts;
    }

    public boolean addToCart(String userId, String productId){
        User currentUser=userService.getAllUser().get(userService.getUser(userId));
        Integer index=productService.getProduct(productId);
        System.out.println(index);
        Product currentProduct=productService.getAllProduct().get(index);
        if (currentUser==null || currentProduct ==null){
           return false;
        }
        addProduct(currentProduct,userId);
        return true;
    }

    public void addProduct(Product product,String userId){
        Cart currentCart=searchForCart(userId);
        if (currentCart==null){
            currentCart=new Cart(cartNumber+"",userId);
            cartNumber++;
            carts.add(currentCart);
        }
        currentCart.getProducts().add(product);

    }

    public boolean removeFromCart(String userId, String productId){
        User currentUser=userService.getAllUser().get(userService.getUser(userId));
        Product currentProduct=productService.getAllProduct().get(productService.getProduct(productId));
        if (currentUser==null || currentProduct ==null){
            return false;
        }
        if(!removeProduct(currentProduct,userId)){
           return false;
        }
        return true;
    }

    public boolean removeProduct(Product currentProduct, String userId) {
        Cart currentCart=searchForCart(userId);
        if (currentCart==null){
          return false;
        }
        return currentCart.getProducts().remove(currentProduct);
    }

    public boolean buyWithCart(Cart cart){
        User currentUser=userService.getAllUser().get(userService.getUser(cart.getUserId()));
        Double totalPrice = orderService.buyWithCart(cart,currentUser.getBalance());
        if (totalPrice ==0.0){
            return false;
        }
        currentUser.setBalance(currentUser.getBalance()-totalPrice);
        return true;
    }

    public Cart searchForCart(String userId){
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getUserId().equals(userId)){
                return carts.get(i);
            }
        }
        return null;
    }


}
