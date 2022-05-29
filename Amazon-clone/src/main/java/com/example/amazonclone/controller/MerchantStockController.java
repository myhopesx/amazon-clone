package com.example.amazonclone.controller;


import com.example.amazonclone.model.MerchantStock;
import com.example.amazonclone.service.MerchantStockProductService;
import com.example.amazonclone.service.MerchantStockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/merchantstock")
@AllArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;
    private final MerchantStockProductService merchantStockProductService;

    @GetMapping
    public ResponseEntity<ArrayList<MerchantStock>> getMerchantStock(){
        return ResponseEntity.status(200).body(merchantStockService.getAllMerchantStock());
    }

    @PostMapping
    public ResponseEntity postMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors error){

        if (error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(201).body("Welcome to our Amazon website!!!!");
    }

    @PutMapping
    public ResponseEntity updateMerchantStock(@RequestBody @Valid MerchantStock merchantStock, Errors errors ){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        merchantStockService.updateMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("MerchantStock has updated");
    }

    @PutMapping("/{merchantid}/{productid}/{stock}")
    public ResponseEntity addProductToMerchantStock(@PathVariable String merchantid , @PathVariable String productid, @PathVariable Integer stock ){
        merchantStockProductService.addProductToMerchantStock(merchantid,productid,stock);
        return ResponseEntity.status(200).body("product has been add to your merchant stock !!");
    }

    @DeleteMapping("/{merchantStockid}")
    public ResponseEntity deleteMerchantStock(@PathVariable String merchantStockid){

        if(!merchantStockService.deleteMerchantStock(merchantStockid)){
            return ResponseEntity.status(400).body("there is no merchantStock");
        }
        return ResponseEntity.status(200).body("merchantStock has deleted");
    }



}
