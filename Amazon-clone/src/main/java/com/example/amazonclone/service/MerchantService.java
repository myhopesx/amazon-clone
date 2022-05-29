package com.example.amazonclone.service;

import com.example.amazonclone.model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {


    ArrayList<Merchant> merchants = new ArrayList<>();

    public ArrayList<Merchant> getAllMerchant() {
        return this.merchants;
    }

    public boolean addMerchant(Merchant merchant) {
        return merchants.add(merchant);
    }

    public boolean updateMerchant(Merchant merchant) {
        if (merchants.set(getMerchant(merchant.getId()), merchant) != null) {
            return true;
        }
        return false;
    }

    public boolean deleteMerchant(String id) {
        Integer index = getMerchant(id);

        if (index == null) {
            return false;
        }

         merchants.remove((int) index);
        return true;
    }

    public Integer getMerchant(String id) {
        for (int i = 0; i < merchants.size(); i++) {
            if (merchants.get(i).getId().equals(id)) {
                return i;
            }

        }
        return null;

    }
}
