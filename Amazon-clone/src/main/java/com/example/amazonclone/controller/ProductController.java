package com.example.amazonclone.controller;
import com.example.amazonclone.model.Product;
import com.example.amazonclone.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {


    private final ProductService productService;

    @GetMapping
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(productService.getAllProduct());
    }

    @PostMapping
    public ResponseEntity postProduct(@RequestBody @Valid Product product, Errors error){

        if (error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        productService.addProduct(product);
        return ResponseEntity.status(201).body("Welcome to our Amazon website!!!!");
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid Product product, Errors errors ){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        productService.updateProduct(product);
        return ResponseEntity.status(200).body("Product has updated");
    }

    @PutMapping("/{userid}/{productid}/{merchantid}")
    public ResponseEntity buyProduct(@PathVariable String userid,@PathVariable String productid,@PathVariable String merchantid){

        if (!productService.buyProduct(userid,productid,merchantid)){
            return ResponseEntity.status(400).body("invalid purchase , please check your id's and your balance");
        }
        return ResponseEntity.status(200).body("Enjoy with your new product!!");
    }


    @DeleteMapping("/{productid}")
    public ResponseEntity deleteProduct(@PathVariable String productid){

        if(!productService.deleteProduct(productid)){
            return ResponseEntity.status(400).body("there is no product");
        }
        return ResponseEntity.status(200).body("product has deleted");
    }
}
