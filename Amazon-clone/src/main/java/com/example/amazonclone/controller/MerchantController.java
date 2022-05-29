package com.example.amazonclone.controller;
import com.example.amazonclone.model.Merchant;
import com.example.amazonclone.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping
    public ResponseEntity getMerchant(){
        return ResponseEntity.status(200).body(merchantService.getAllMerchant());
    }

    @PostMapping
    public ResponseEntity postMerchant(@RequestBody @Valid Merchant merchant, Errors error){
        if (error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(201).body("Welcome to our Amazon website!!!!");
    }

    @PutMapping
    public ResponseEntity updateMerchant(@RequestBody @Valid Merchant merchant, Errors errors ){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        merchantService.updateMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant has updated");
    }

    @DeleteMapping("/{merchantid}")
    public ResponseEntity deleteMerchant(@PathVariable String merchantid){

        if(!merchantService.deleteMerchant(merchantid)){
            return ResponseEntity.status(400).body("there is no merchant");
        }
        return ResponseEntity.status(200).body("merchant has deleted");
    }
}
