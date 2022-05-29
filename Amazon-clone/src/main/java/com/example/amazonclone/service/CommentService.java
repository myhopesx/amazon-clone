package com.example.amazonclone.service;
import com.example.amazonclone.model.Comment;
import com.example.amazonclone.model.Product;
import com.example.amazonclone.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserService userService;

    private final PurchaseHistoryService purchaseHistoryService;
    private final ProductService productService;
    ArrayList<Comment> comments = new ArrayList<>();

    public ArrayList<Comment> getAllComment() {
        return this.comments;
    }

    public boolean addComment(String userId,String productId,Comment comment){
        Integer index = userService.getUser(userId);
        User currentUser=userService.getAllUser().get(index);
        Product currentProduct=productService.getAllProduct().get(productService.getProduct(productId));
        if(!purchaseHistoryService.getPurchaseHistories(userId,productId)){
            return false;
        }
        return comments.add(comment);
    }

    public ArrayList getAllCommentByProduct(String productId){
        ArrayList <Comment>productComments=new ArrayList<>();
        if (productService.getProduct(productId)==null){
            return productComments;
        }

        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getProductId().equals(productId)){
                productComments.add(comments.get(i));
            }
        }

        return productComments;
    }

    public ArrayList<Comment> getAllFive() {
        ArrayList <Comment>allFiveComments=new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getRate()==5.0){
                allFiveComments.add(comments.get(i));
            }
        }
        return allFiveComments;
    }
}
