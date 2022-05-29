package com.example.amazonclone.controller;


import com.example.amazonclone.model.Category;
import com.example.amazonclone.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity getCategory(){
        return ResponseEntity.status(200).body(categoryService.getAllCategory());
    }

    @PostMapping
    public ResponseEntity postCategory(@RequestBody @Valid Category category, Errors error){
        if (error.hasErrors()){
            return ResponseEntity.status(400).body(error.getFieldError().getDefaultMessage());
        }
        categoryService.addCategory(category);
        return ResponseEntity.status(201).body("Welcome to our Amazon website!!!!");
    }

    @PutMapping
    public ResponseEntity updateCategory(@RequestBody @Valid Category category, Errors errors ){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        categoryService.updateCategory(category);
        return ResponseEntity.status(200).body("Category has updated");
    }

    @DeleteMapping("/{categoryid}")
    public ResponseEntity deleteCategory(@PathVariable String categoryid){

        if(!categoryService.deleteCategory(categoryid)){
            return ResponseEntity.status(400).body("there is no category");
        }
        return ResponseEntity.status(200).body("category has deleted");
    }
}
