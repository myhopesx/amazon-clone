package com.example.amazonclone.service;


import com.example.amazonclone.model.Cart;
import com.example.amazonclone.model.MerchantStock;
import com.example.amazonclone.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final MerchantStockService merchantStockService;

    public MerchantStock searchForProductInStock(String productId, String merchantId) {
        for (int i = 0; i < merchantStockService.getAllMerchantStock().size(); i++) {

            if (merchantStockService.getAllMerchantStock().get(i).getProductId().equals(productId) &&
                    merchantStockService.getAllMerchantStock().get(i).getMerchantId().equals(merchantId)) {
                return merchantStockService.getAllMerchantStock().get(i);
            }

        }
        return null;
    }

    public Double buyWithCart(Cart cart , Double balance) {
        Double totalPrice = 0.0;
        ArrayList<MerchantStock> merchantStocks = merchantStockService.getAllMerchantStock();
        boolean isFound = false;

        for (int i = 0; i < cart.getProducts().size(); i++) {


            for (int j = 0; j < merchantStocks.size(); j++) {

                System.out.println(merchantStocks.get(j).getProductId().trim().equalsIgnoreCase(cart.getProducts().get(i).getId().trim()) + "====");
                System.out.println(merchantStocks.get(j).getProductId()+"A");
                System.out.println(cart.getProducts().get(i).getId()+"A");

                if (cart.getProducts().get(i).getId().trim().equalsIgnoreCase(merchantStocks.get(j).getProductId().trim())) {
                    System.out.println("in");
                    totalPrice += cart.getProducts().get(i).getPrice();

                    isFound = true;
                } else {
                    isFound = false;
                }
            }
        }

        if (balance<totalPrice || !isFound){
          return 0.0;
        }

        reduceStock(cart);

        return totalPrice;
    }

    public void reduceStock(Cart cart) {
        for (int i = 0; i < cart.getProducts().size(); i++) {
            for (int j = 0; j < merchantStockService.getAllMerchantStock().size(); j++) {
                if (cart.getProducts().get(i).getId().equals(merchantStockService.getAllMerchantStock().get(j)
                        .getProductId())) {
                    merchantStockService.getAllMerchantStock().get(j)
                            .setStock(merchantStockService.getAllMerchantStock().get(j).getStock()-1);
                }
            }
        }
    }
}
