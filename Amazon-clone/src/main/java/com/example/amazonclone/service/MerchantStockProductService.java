package com.example.amazonclone.service;

import com.example.amazonclone.model.Merchant;
import com.example.amazonclone.model.MerchantStock;
import com.example.amazonclone.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MerchantStockProductService {

     private final ProductService productService;
     private final MerchantService merchantService;
     private final MerchantStockService merchantStockService;

     public boolean addProductToMerchantStock(String merchantId,String productId,Integer stock){

          Product currentProduct=productService.getAllProduct().get(productService.getProduct(productId));
          Merchant currentMerchant=merchantService.getAllMerchant().get(merchantService.getMerchant(merchantId));

          if (currentProduct==null||currentMerchant== null || stock<10){
               return false;
          }

          if (merchantStockService.getMerchantStock(merchantStockService.merchantStockId+"")!=null){
               merchantStockService.merchantStockId++;
          }

          merchantStockService.merchantStockId++;

          return merchantStockService.merchantStocks.add(new MerchantStock(merchantStockService.merchantStockId+"",productId,merchantId,stock));
     }

}
