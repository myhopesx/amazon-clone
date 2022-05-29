package com.example.amazonclone.controller;
import com.example.amazonclone.model.Cart;
import com.example.amazonclone.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping
    public ResponseEntity getCart(){
        return ResponseEntity.status(200).body(cartService.getAllCart());
    }

    @PutMapping("/{userid}/{productid}")
    public ResponseEntity addToCart(@PathVariable String userid,@PathVariable String productid){
        if (!cartService.addToCart(userid,productid)){
            return ResponseEntity.status(400).body("user or product not found");
        }
        return ResponseEntity.status(200).body("nice!! we add the product");
    }

    @DeleteMapping("/{userid}/{productid}")
    public ResponseEntity removeFromCart(@PathVariable String userid,@PathVariable String productid){
        if (!cartService.removeFromCart(userid,productid)){
            return ResponseEntity.status(400).body("user or product not found");
        }
        return ResponseEntity.status(200).body("oh oh!! we remove the product");
    }

    @PutMapping("/buy")
    public ResponseEntity addToCart(@RequestBody Cart cart){
        if (!cartService.buyWithCart(cart)){
            return ResponseEntity.status(400).body("please check ll of your information and your balance");
        }
        return ResponseEntity.status(200).body("Enjoy your purchase");
    }
}
