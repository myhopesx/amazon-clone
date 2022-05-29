package com.example.amazonclone.service;


import com.example.amazonclone.model.PurchaseHistory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PurchaseHistoryService {

    ArrayList<PurchaseHistory> purchaseHistories = new ArrayList<>();

    public ArrayList<PurchaseHistory> getAllPurchaseHistory() {
        return this.purchaseHistories;
    }

    public ArrayList<PurchaseHistory> getAllPurchaseHistoryUser(String userId){
        ArrayList<PurchaseHistory> purchaseHistory=new ArrayList<>();
        for (int i = 0; i < purchaseHistories.size(); i++) {
            if (purchaseHistories.get(i).getUserid().equals(userId)){
                purchaseHistory.add(purchaseHistories.get(i));
            }
        }
          return purchaseHistory;
    }

    public boolean getPurchaseHistories(String userid,String productId){
        for (int i = 0; i < purchaseHistories.size(); i++) {
            if (purchaseHistories.get(i).getProductId().equals(productId)
            &&purchaseHistories.get(i).getUserid().equals(userid)){
                return true;
            }
        }
        return false;
    }
}
