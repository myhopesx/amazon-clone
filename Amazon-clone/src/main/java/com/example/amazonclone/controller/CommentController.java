package com.example.amazonclone.controller;
import com.example.amazonclone.model.Comment;
import com.example.amazonclone.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    public ResponseEntity getComment(){
        return ResponseEntity.status(200).body(commentService.getAllComment());
    }

    @GetMapping("/{productid}")
    public ResponseEntity getCommentByProduct(@PathVariable String productid){
        ArrayList<Comment> productComments=commentService.getAllCommentByProduct(productid);
        if (productComments.size()==0){
            return ResponseEntity.status(400).body("There is no comments in this product");
        }
        return ResponseEntity.status(200).body(productComments);
    }

    @GetMapping("/topfive")
    public ResponseEntity getAllFive(){
        ArrayList<Comment> allFiveProduct=commentService.getAllFive();
        if (allFiveProduct.size()==0){
            return ResponseEntity.status(400).body("There is no comments in this product");
        }
        return ResponseEntity.status(200).body(allFiveProduct);
    }


    @PostMapping("/{userid}/{productid}")
    public ResponseEntity postComment(@RequestBody @Valid Comment comment,@PathVariable String userid ,
                                      @PathVariable String productid, Errors errors){
        if (errors.hasErrors() ){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }

        if (!commentService.addComment(userid,productid,comment)){
            return ResponseEntity.status(400).body("please check all of your information " +
                    "and make sure that you already buy this product!!!");
        }
        return ResponseEntity.status(201).body(" Thank you!! we receive your comment!!!");
    }
}
