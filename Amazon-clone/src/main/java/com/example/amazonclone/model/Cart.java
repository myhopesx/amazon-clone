package com.example.amazonclone.model;


import com.example.amazonclone.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Cart {

    @NotEmpty(message = "id cannot be empty")
    @Size(min = 3,max = 3 , message = "id have to be 3 character long")
    private String id ;

    @NotEmpty(message = "user id cannot be empty")
    @Size(min = 3,max = 3 , message = "user have to be 3 character long")
    private String userId ;
    private ArrayList<Product> products;

    public Cart(String id, String userId) {
        this.id = id;
        this.userId = userId;
        this.products = new ArrayList<>();
    }

}
