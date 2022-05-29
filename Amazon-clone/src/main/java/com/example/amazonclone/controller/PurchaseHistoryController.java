package com.example.amazonclone.controller;

import com.example.amazonclone.service.PurchaseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/purchaseHistory")
@RequiredArgsConstructor
public class PurchaseHistoryController {

    private final PurchaseHistoryService purchaseHistoryService;

    @GetMapping
    public ResponseEntity getAllPurchaseHistory(){
        return ResponseEntity.status(200).body(purchaseHistoryService.getAllPurchaseHistory());
    }

    @GetMapping("/{userid}")
    public ResponseEntity getAllPurchaseHistoryForUser(@PathVariable String userid){
        ArrayList purchaseByUser = purchaseHistoryService.getAllPurchaseHistoryUser(userid);
        if (purchaseByUser.size()==0){
            return ResponseEntity.status(400).body("There is no purchase history for this user");
        }
        return ResponseEntity.status(200).body(purchaseByUser);
    }

}
