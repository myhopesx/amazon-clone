package com.example.amazonclone.service;

import com.example.amazonclone.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProductService {

     private long purchaseHistoryId = 100;
     private final OrderService orderService;
     private final UserService userService;
     private final PurchaseHistoryService purchaseHistoryService;
     ArrayList<Product> products = new ArrayList<>();

     public ArrayList<Product> getAllProduct() {
          return this.products;
     }

     public boolean addProduct(Product product) {
          return products.add(product);
     }

     public boolean updateProduct(Product product) {
          if (products.set(getProduct(product.getId()), product) != null) {
               return true;
          }
          return false;
     }


     public boolean buyProduct(String userId, String productId, String merchantId) {

          User currentUser = userService.getAllUser().get(userService.getUser(userId));
          MerchantStock currentMerchantStock = orderService.searchForProductInStock(productId, merchantId);
          Product currentProduct = getAllProduct().get(getProduct(productId));

          if (currentUser == null || currentMerchantStock == null || currentUser.getBalance() < currentProduct.getPrice()) {
               return false;
          }

          currentMerchantStock.setStock(currentMerchantStock.getStock() - 1);
          currentUser.setBalance(currentUser.getBalance() - currentProduct.getPrice());
          purchaseHistoryService.getAllPurchaseHistory().add(new PurchaseHistory
                  (purchaseHistoryId + "", userId, productId, currentProduct.getPrice()));
          return true;

     }

     public boolean deleteProduct(String id) {
          Integer index = getProduct(id);

          if (index == null) {
               return false;
          }

          products.remove((int)index);

          return true;
     }


     public Integer getProduct(String id) {
          for (int i = 0; i < products.size(); i++) {
               if (products.get(i).getId().equals(id)) {
                    return i;
               }

          }
          return null;

     }

}
