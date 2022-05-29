package com.example.amazonclone.service;

import com.example.amazonclone.model.Merchant;
import com.example.amazonclone.model.MerchantStock;
import com.example.amazonclone.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MerchantStockService {

     long merchantStockId = 99;
     ArrayList<MerchantStock> merchantStocks = new ArrayList<>();

     public ArrayList<MerchantStock> getAllMerchantStock() {
          return this.merchantStocks;
     }

     public boolean addMerchantStock(MerchantStock merchantStock) {
          return merchantStocks.add(merchantStock);
     }

     public boolean updateMerchantStock(MerchantStock merchantStock) {
          if (merchantStocks.set(getMerchantStock(merchantStock.getId()), merchantStock) != null) {
               return true;
          }
          return false;
     }

     public boolean deleteMerchantStock(String id) {
          Integer index = getMerchantStock(id);

          if (index == null) {
               return false;
          }

          merchantStocks.remove((int) index);

          return true;
     }


     public Integer getMerchantStock(String id) {
          for (int i = 0; i < merchantStocks.size(); i++) {
               if (merchantStocks.get(i).getId().equals(id)) {
                    return i;
               }

          }
          return null;

     }
}
